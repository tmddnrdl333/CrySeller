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

    public List<CategoryResponseDto.NoAndNameRes> getCategoryList() {
        List<CategoryResponseDto.NoAndNameRes> noAndNameResList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            noAndNameResList.add(new CategoryResponseDto.NoAndNameRes(category));
        }
        return noAndNameResList;
    }

    public CategoryResponseDto.NoAndNameRes getCategoryDetail(int no) {
        return new CategoryResponseDto.NoAndNameRes(
                categoryRepository.findByNo(no) // 없으면 throw exception
        );
    }
}
