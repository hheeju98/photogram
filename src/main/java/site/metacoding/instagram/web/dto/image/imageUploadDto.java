package site.metacoding.instagram.web.dto.image;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class imageUploadDto {
    private MultipartFile file;
    private String caption;
}
