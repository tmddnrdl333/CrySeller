package numble.cryseller.backend.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.cryseller.backend.domain.entity.Category;

// @TODO:
// category를 선택하면 ItemRequestDto를 생성할 때 no로 find해서 Category Entity를 생성한다.
// 근데 이 때 그냥 no만 있으면 되니까 RequestDto까지는 필요가 없다.
// 하지만 만약에 나중에 관리자 권한으로 카테고리 추가 제거 수정 등을 구현해야 한다면,
// 이 RequestDto를 쓰게 될 것 같다.

@Getter
@NoArgsConstructor
public class CategoryRequestDto {
    private int no;
    private String name;

    @Builder
    public CategoryRequestDto(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public Category toEntity() {
        return Category.builder()
                .no(no)
                .name(name)
                .build();
    }
}
