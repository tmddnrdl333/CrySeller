package numble.cryseller.backend.api.dto;

import lombok.*;

public class CategoryRequestDto {

    // NoAndNameReq: 카테고리의 번호와 이름
    // DB 설계 시 생성한 것으로 활용할 예정이나,
    // 추후 카테고리 추가/제거/수정을 구현하게 된다면 이 Dto가 필요하게 될 것이다.
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class NoAndNameReq {
        private int no;
        private String name;
    }
}
