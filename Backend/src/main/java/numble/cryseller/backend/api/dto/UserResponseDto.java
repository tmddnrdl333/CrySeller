package numble.cryseller.backend.api.dto;

import lombok.*;
import numble.cryseller.backend.domain.entity.User;

import java.time.LocalDateTime;

public class UserResponseDto {

    // UserInfo: 회원의 공개 가능한 정보
    // 회원 본인, 혹은 관리자에게 노출되는 회원의 정보
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserInfo {
        private int no;
        private String id;
        private LocalDateTime registerDateTime;

        public UserInfo(User user) {
            this.no = user.getNo();
            this.id = user.getId();
            this.registerDateTime = user.getRegisterDateTime();
        }
    }
}
