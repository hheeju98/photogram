package site.metacoding.instagram.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.instagram.config.auth.PrincipalDetails;
import site.metacoding.instagram.service.UserService;
import site.metacoding.instagram.web.dto.user.UserProfileDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{pageUserId}")
    public String profile(@PathVariable int pageUserId, Model model,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {
        UserProfileDto dto = userService.회원프로필(pageUserId, principalDetails.getUser().getId());
        model.addAttribute("dto", dto);
        return "user/profile";
    }

    @GetMapping("/user/{id}/update")
    public String updateForm(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        // 1. 추천
        // System.out.println("세션 정보 : "+principalDetails.getUser());

        // 2. 극혐
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
        // System.out.println("직접 찾은 세션 정보 : "+mPrincipalDetails.getUser());

        return "user/update";
    }

}