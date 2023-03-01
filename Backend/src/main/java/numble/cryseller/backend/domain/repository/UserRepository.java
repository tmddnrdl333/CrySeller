package numble.cryseller.backend.domain.repository;

import numble.cryseller.backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
}
