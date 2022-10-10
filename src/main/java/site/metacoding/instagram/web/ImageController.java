package site.metacoding.instagram.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.instagram.config.auth.PrincipalDetails;
import site.metacoding.instagram.handler.ex.CustomValidationException;
import site.metacoding.instagram.service.ImageService;
import site.metacoding.instagram.web.dto.image.imageUploadDto;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageService imageService;

    @GetMapping({ "/", "/image/story" })
    public String story() {
        return "image/story";
    }

    @GetMapping("/image/popular")
    public String popular() {
        return "image/popular";
    }

    @GetMapping("/image/upload")
    public String upload() {
        return "image/upload";
    }

    @PostMapping("/image")
    public String imageUpload(imageUploadDto imageUploadDto,
            @AuthenticationPrincipal PrincipalDetails principalDetails) {

        if (imageUploadDto.getFile().isEmpty()) {
            System.out.println("이미지가 첨부되지 않았습니다.");
            throw new CustomValidationException("이미지가 첨부되지 않았습니다.", null);
        }
        // 서비스 호출
        imageService.사진업로드(imageUploadDto, principalDetails);
        return "redirect:/user/" + principalDetails.getUser().getId();
    }
}
