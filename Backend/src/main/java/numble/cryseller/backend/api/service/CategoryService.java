package numble.cryseller.backend.api.service;

import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.CategoryResponseDto;
import numble.cryseller.backend.domain.entity.Category;
import numble.cryseller.backend.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDto> getCategoryList() {
        List<CategoryResponseDto> categoryResponseDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            categoryResponseDtoList.add(new CategoryResponseDto(category));
        }
        return categoryResponseDtoList;
    }

    public CategoryResponseDto getCategoryDetail(int no) {
        return new CategoryResponseDto(
                categoryRepository.findByNo(no)
        );
    }
}
