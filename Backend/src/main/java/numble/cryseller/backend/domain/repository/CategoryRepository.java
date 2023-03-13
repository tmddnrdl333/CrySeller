package numble.cryseller.backend.domain.repository;

import numble.cryseller.backend.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByNo(int no);
}
