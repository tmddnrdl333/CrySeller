package numble.cryseller.backend.api.dto;

import lombok.*;
import numble.cryseller.backend.domain.entity.Category;
import numble.cryseller.backend.domain.entity.Item;

import java.time.LocalDateTime;

public class ItemResponseDto {

    // ItemInfoRes: 상품의 정보
    // 구매자에게 노출되는 상품의 모든 정보
    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ItemInfoRes {

        private Category category; // find해서 넣어야 할듯
        private String name;
        private String imgLink;
        private int quantity;
        private int price;
        private int discountRate;
        private String info;
        private LocalDateTime registerDateTime;
        private LocalDateTime availableDateTime;

        public ItemInfoRes(Item item) {
            this.category = item.getCategory();
            this.name = item.getName();
            this.imgLink = item.getImgLink();
            this.quantity = item.getQuantity();
            this.price = item.getPrice();
            this.discountRate = item.getDiscountRate();
            this.info = item.getInfo();
            this.registerDateTime = item.getRegisterDateTime();
            this.availableDateTime = item.getAvailableDateTime();
        }
    }
}
