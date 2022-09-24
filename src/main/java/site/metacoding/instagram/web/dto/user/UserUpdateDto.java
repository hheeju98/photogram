package site.metacoding.instagram.web.dto.user;

import lombok.Data;
import site.metacoding.instagram.domain.user.User;

@Data
public class UserUpdateDto {
    private String name; // 필수
    private String password; // 필수
    private String website;
    private String bio;
    private String phone;
    private String gender;

    // 조금 위험. 코드수정 필요
    public User toEntity() {
        return User.builder()
                .name(name)
                .password(password)
                .website(website)
                .bio(bio)
                .phone(phone)
                .gender(gender)
                .build();
    }
}