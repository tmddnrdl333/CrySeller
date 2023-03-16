package numble.cryseller.backend.api.dto;

import lombok.*;

public class UserRequestDto {

    // IdAndPw: 회원의 Id와 Pw
    // 회원가입, 로그인, 회원탈퇴에 사용되는 정보
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class IdAndPw {
        private String id;
        private String pw;
    }

}
