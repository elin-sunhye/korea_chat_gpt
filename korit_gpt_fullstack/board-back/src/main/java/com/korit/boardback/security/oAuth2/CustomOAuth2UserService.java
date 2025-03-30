package com.korit.boardback.security.oAuth2;

import com.korit.boardback.entity.User;
import com.korit.boardback.entity.UserRole;
import com.korit.boardback.repository.UserRepository;
import com.korit.boardback.repository.UserRoleRepository;
import com.korit.boardback.security.principal.PrincipalUser;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private DefaultOAuth2UserService defaultOAuth2UserService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String oAuth2Name = null;
        String oAuth2Email = null;
        String oAuth2Provider = userRequest.getClientRegistration().getRegistrationId();
        Map<String, Object> attributes = getDefaultOAuth2User(userRequest).getAttributes();

        if(oAuth2Provider.equalsIgnoreCase("naver")) {
            attributes = (Map<String, Object>) attributes.get("response");
            oAuth2Name = (String) attributes.get("id");
            oAuth2Email = (String) attributes.get("email");
        }

        if(oAuth2Provider.equalsIgnoreCase("google")) {
            oAuth2Name = (String) attributes.get("sub");
            oAuth2Email = (String) attributes.get("email");
        }

        final String USERNAME = oAuth2Provider + "_" + oAuth2Name;
        final String EMAIL = oAuth2Email;
        final String NAME = oAuth2Name;

        User user = userRepository.findByUsername(USERNAME).orElseGet(() -> {
            User newUser = User.builder()
                    .username(USERNAME)
                    .nickname(USERNAME)
                    .email(EMAIL)
                    .oAuth2Name(NAME)
                    .oAuth2Provider(oAuth2Provider)
                    .accountExpired(1)
                    .accountLocked(1)
                    .credentialsExpired(1)
                    .accountEnabled(1)
                    .build();
            User savedUser = userRepository.save(newUser);

            UserRole userRole = UserRole.builder()
                    .userId(savedUser.getUserId())
                    .roleId(1)
                    .build();
            userRoleRepository.save(userRole);

            return userRepository.findByUsername(USERNAME).get();
        });

        return PrincipalUser.builder()
                .user(user)
                .name(oAuth2Name)
                .attributes(attributes)
                .build();
    }

    private OAuth2User getDefaultOAuth2User(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return defaultOAuth2UserService.loadUser(userRequest);

    }
}
