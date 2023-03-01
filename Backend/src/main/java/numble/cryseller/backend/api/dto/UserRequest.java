package numble.cryseller.backend.api.dto;

import lombok.*;

public class UserRequest {
    @Data
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserIdAndPw {
        private String id;
        private String pw;
    }
}
