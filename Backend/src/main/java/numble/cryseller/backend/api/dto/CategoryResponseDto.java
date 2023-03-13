package numble.cryseller.backend.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.cryseller.backend.domain.entity.Category;

@Getter
@NoArgsConstructor
public class CategoryResponseDto {
    private int no;
    private String name;

    public CategoryResponseDto(Category category) {
        this.no = no;
        this.name = name;
    }
}
