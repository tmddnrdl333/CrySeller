package numble.cryseller.backend.api.dto;

import lombok.*;
import numble.cryseller.backend.domain.entity.Category;

public class CategoryResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class NoAndNameRes {
        private int no;
        private String name;

        public NoAndNameRes(Category category) {
            this.no = category.getNo();
            this.name = category.getName();
        }
    }
}
