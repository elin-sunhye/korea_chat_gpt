package com.korit.boardback.service;

import com.korit.boardback.entity.User;
import com.korit.boardback.repository.UserRepository;
import com.korit.boardback.security.jwt.JwtUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

/** 메일 전송 셋팅*/
@Service
public class EmailService {
//    @Value("${spring.mail.username}")
    private final String FROM_EMAIL = "tjsgp43@gmail.com";

    @Autowired
    private UserRepository userRepository;

    @Autowired(required = false)
    private JavaMailSender javaMailSender;

    @Autowired
    private JwtUtil jwtUtil;

    @Async
    public void sendAuthMail(String to, String username) throws MessagingException {
        Date expires = new Date(new Date().getTime() + (1000l * 60 * 5));
//        이메일 인증 토큰 생성
        String emailToken = jwtUtil.generateToken(null, null, expires);
        String href = "http://localhost:8080/api/auth/email?username=" + username +"&token=" + emailToken;

        final String SUBJECT = "[board_pj] 계정 활성화 인증 메일입니다.";
        String cont = String.format("""
                    <html lang="ko">
                    <head>
                        <meta charset="UTF-8">
                    </head>
                    <body>
                      <div style="display: flex; flex-direction: column; justify-content: center; align-items: center">
                        <h1>계정 활성화</h1>
                        <p>계정 활성화를 하시려면 아래의 인증 버튼을 클릭하세요.</p>
                        <a href="%s" target="_blank" style="box-sizing: border-box; padding: 7px 15px; border: none; border-radius: 8px; color: #fff; text-decoration: none; background-color: #2383e2;">
                          인증하기
                        </a>
                      </div>
                    </body>
                    </html>
                """, href);

//        StringBuilder builder = new StringBuilder();
//        builder.append("<html>");
//            builder.append("<body>");
//                builder.append("""
//
//                        """);
//            builder.append("</body>");
//        builder.append("</html>");

        sendMail(to, SUBJECT, cont);
    }

//    메일 전송 공통 메서드
    public void sendMail(String to, String subject, String cont) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, StandardCharsets.UTF_8.name());

        mimeMessageHelper.setFrom(FROM_EMAIL);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);

        mimeMessage.setText(cont, StandardCharsets.UTF_8.name(), "html");

        javaMailSender.send(mimeMessage);
    }

    @Transactional(rollbackFor = Exception.class)
    public String auth(String username, String token) {
        String respMsg = "";

        try {
            jwtUtil.parseToken(token);

            Optional<User> userOptional = userRepository.findByUsername(username);
            if(userOptional.isEmpty()) {
                respMsg = "[인증실패] 존재하지 않는 사용자입니다.";
            } else {
                User user = userOptional.get();
                if(user.getAccountEnabled() == 1) {
                    respMsg = "[인증실패] 이미 인증된 사용자입니다.";
                } else {
                    userRepository.updateAccountEnabled(username);
                    respMsg = "[인증성공] 인증에 성공하였습니다.";
                }
            }
        } catch (Exception e) {
            respMsg = "[인증실패] 토큰이 유효하지 않거나 인증 시간을 초과하였습니다.";
        }

        return respMsg;
    }

    public String generateEmailCode() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000000));
    }

    @Async
    public void sendChangeEmailVerification(String to, String code) throws MessagingException {
        final String SUBJECT = "[board_pj] 이메일 변경을 위한 사용자 인증 메일입니다.";
        String cont = String.format("""
                    <html lang="ko">
                    <head>
                        <meta charset="UTF-8">
                    </head>
                    <body>
                      <div style="display: flex; flex-direction: column; justify-content: center; align-items: center">
                        <h1>이메일 인증</h1>
                        <p>계정의 이메일을 변경 하시려면 아래의 인증 코드번호를 확인하세요.</p>
                        <h3 style="background-color: #2383e2; color: #fff; margin: 20px;">%s</h3>
                      </div>
                    </body>
                    </html>
                """, code);

        sendMail(to, SUBJECT, cont);
    }
}
