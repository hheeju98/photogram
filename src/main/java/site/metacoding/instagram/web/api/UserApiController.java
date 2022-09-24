package site.metacoding.instagram.web.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.instagram.web.dto.user.UserUpdateDto;

@RestController
public class UserApiController {

    @PutMapping("/api/user/{id}")
    public String update(UserUpdateDto userUpdateDto) {
        System.out.println(userUpdateDto);
        return "ok";
    }
}
