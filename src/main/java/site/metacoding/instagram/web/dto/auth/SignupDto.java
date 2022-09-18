package site.metacoding.instagram.web.dto.auth;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import site.metacoding.instagram.domain.user.User;

@Data // Getter, Setter
public class SignupDto {
    @Max(20)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
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
