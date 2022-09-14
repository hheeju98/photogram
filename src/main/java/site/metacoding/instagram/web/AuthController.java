package site.metacoding.instagram.web;

import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import site.metacoding.instagram.web.dto.auth.SignupDto;

@Controller // 1.IoC 2.파일을 리턴하는 컨트롤러
public class AuthController {
    private static final org.jboss.logging.Logger log = LoggerFactory.logger(AuthController.class);

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입 버튼 -> /auth/signup -> /auth/signin
    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) { // key=value (x-www-form-urlencoded)
        log.info(signupDto.toString());
        return "auth/signin";
    }
}
