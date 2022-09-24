package site.metacoding.instagram.web.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.instagram.config.auth.PrincipalDetails;
import site.metacoding.instagram.domain.user.User;
import site.metacoding.instagram.service.UserService;
import site.metacoding.instagram.web.dto.auth.CMRespDto;
import site.metacoding.instagram.web.dto.user.UserUpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable int id, UserUpdateDto userUpdateDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity); // 세션 정보 변경
        return new CMRespDto<>(1, "회원수정 완료", userEntity);
    }
}
