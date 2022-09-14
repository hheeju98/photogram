package site.metacoding.instagram.web.dto.auth;

import lombok.Data;
import site.metacoding.instagram.domain.user.User;

@Data // Getter, Setter
public class SignupDto {
    private String username;
    private String password;
    private String email;
    private String name;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();

    }
}
