package numble.cryseller.backend.api.dto;

import lombok.*;

import java.time.LocalDateTime;

public class UserResponse {
    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserNoAndRegisterDateTime {
        private int userNo;
        private LocalDateTime registerDateTime;
    }
}
