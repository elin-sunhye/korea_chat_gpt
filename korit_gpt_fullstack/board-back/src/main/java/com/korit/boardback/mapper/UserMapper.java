package com.korit.boardback.mapper;

import com.korit.boardback.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User selectByUserId(int userId);
    User selectByUsername(String username);
    User selectByEmail(String email);

    int insert(User user);

    int updateProfileImgByUserId(
            @Param("userId") int userId,
            @Param("profileImg") String profileImg
    );

    int updateNicknameByUserId(
            @Param("userId") int userId,
            @Param("nickname") String nickname
    );

    int updatePasswordByUserId(
            @Param("userId") int userId,
            @Param("password") String password
    );

    int updateAccountEnabledByUsername(
            @Param("username") String username
    );

    int updateEmailByUserId(
            @Param("userId") int userId,
            @Param("email") String email
    );

}
