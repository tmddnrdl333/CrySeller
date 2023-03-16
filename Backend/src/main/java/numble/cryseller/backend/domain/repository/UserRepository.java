package numble.cryseller.backend.domain.repository;

import numble.cryseller.backend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: @Repository 필요 없나?
// JPA 관련 정리한 문서에는, 필요 없고, Entity와 같은 dir에 위치하라고 했다.
// 근데 같은 위치에 두지 않아서 @Repository가 필요한건가? 테스트 후 다시 보자.
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNo(int no);

    User findByIdAndPw(String id, String pw);

    long deleteByIdAndPw(String id, String pw);
}
