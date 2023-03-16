package numble.cryseller.backend.api.service;

import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.UserRequestDto;
import numble.cryseller.backend.api.dto.UserResponseDto;
import numble.cryseller.backend.domain.entity.User;
import numble.cryseller.backend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto.UserInfo signup(UserRequestDto.IdAndPw idAndPw) {
        return new UserResponseDto.UserInfo(
                userRepository.save(
                        User.builder()
                                .id(idAndPw.getId())
                                .pw(idAndPw.getPw())
                                .build()
                )
        );
    }

    @Transactional
    public void withdrawal(UserRequestDto.IdAndPw idAndPw) {
        userRepository.deleteByIdAndPw(idAndPw.getId(), idAndPw.getPw());
    }

    public List<UserResponseDto.UserInfo> getUserList() {
        List<UserResponseDto.UserInfo> userInfoList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            userInfoList.add(new UserResponseDto.UserInfo(user));
        }
        return userInfoList;
    }

    public UserResponseDto.UserInfo getUserDetail(int no) {
        return new UserResponseDto.UserInfo(
                userRepository.findByNo(no) // 없을 경우 throw exception
        );
    }

    public UserResponseDto.UserInfo login(UserRequestDto.IdAndPw idAndPw) {
        return new UserResponseDto.UserInfo(
                userRepository.findByIdAndPw(idAndPw.getId(), idAndPw.getPw()) // 없을 경우 throw exception
        );
    }
}
