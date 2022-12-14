package site.metacoding.instagram.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.instagram.domain.user.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileDto {
    private boolean pageOwnerState;
    private Integer imageCount;
    private boolean subscribeState;
    private Integer subscribeCount;
    private User user;
}
