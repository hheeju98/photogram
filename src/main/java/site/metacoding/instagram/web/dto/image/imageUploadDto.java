package site.metacoding.instagram.web.dto.image;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import site.metacoding.instagram.domain.image.Image;
import site.metacoding.instagram.domain.user.User;

@Data
public class imageUploadDto {
    private MultipartFile file;
    private String caption;

    public Image toEntity(String postImageUrl, User user) {
        return Image.builder()
                .caption(caption)
                .postImageUrl(postImageUrl)
                .user(null)
                .build();
    }
}
