package numble.cryseller.backend.api.service;

import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.UserRequest;
import numble.cryseller.backend.api.dto.UserResponse;
import numble.cryseller.backend.domain.entity.User;
import numble.cryseller.backend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse.UserNoAndRegisterDateTime signup(UserRequest.UserIdAndPw userIdAndPw) {
        User user = new User();
        user.setId(userIdAndPw.getId());
        user.setPw(userIdAndPw.getPw());
        return userRepository.save(user);
    }
}
