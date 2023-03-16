package numble.cryseller.backend.api.dto;

import lombok.*;

import java.time.LocalDateTime;

public class ItemRequestDto {

    // ItemInfoReq: 상품의 정보
    // 등록, 수정에 사용되는 모든 정보
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ItemInfoReq {
        private int category_no;
        private String name;
        private String imgLink;
        private int quantity;
        private int price;
        private int discountRate;
        private String info;
        private LocalDateTime availableDateTime;
    }
}
