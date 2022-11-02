package site.metacoding.instagram.web.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.instagram.config.auth.PrincipalDetails;
import site.metacoding.instagram.domain.user.User;
import site.metacoding.instagram.handler.ex.CustomValidationApiException;
import site.metacoding.instagram.service.SubscribeService;
import site.metacoding.instagram.service.UserService;
import site.metacoding.instagram.web.dto.auth.CMRespDto;
import site.metacoding.instagram.web.dto.subscribe.SubscribeDto;
import site.metacoding.instagram.web.dto.user.UserUpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final SubscribeService subscribeService;

    @GetMapping("/api/user/1/{pageUserId}/subscribe")
    public ResponseEntity<?> subscribeList(@PathVariable Integer pageUserId,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {

        List<SubscribeDto> subscribeDto = subscribeService.구독리스트(principalDetails.getUser().getId(), pageUserId);

        return new ResponseEntity<>(new CMRespDto<>(1, "구독자 정보 리스트 가져오기 성공", subscribeDto), HttpStatus.OK);
    }

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(
            @PathVariable Integer id,
            @Valid UserUpdateDto userUpdateDto,
            BindingResult bindingResult, // 꼭 @Valid가 적혀있는 다음 파라메터에 적어야됨
            @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {

            }
            throw new CustomValidationApiException("유효성 검사 실패함", errorMap);
        } else {
            User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
            principalDetails.setUser(userEntity); // 세션 정보 변경
            return new CMRespDto<>(1, "회원수정 완료", userEntity); // 응답시에 userEntity의 모은 getter함수가 호출되고 JSON으로 파싱하여 응답한다.
        }
    }
}
