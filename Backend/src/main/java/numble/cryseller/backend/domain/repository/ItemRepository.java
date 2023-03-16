package numble.cryseller.backend.domain.repository;

import numble.cryseller.backend.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findByNo(int no);

    void deleteByNo(int no);
}
