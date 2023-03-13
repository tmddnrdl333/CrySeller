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

    public UserResponseDto signup(UserRequestDto userRequestDto) {
        return new UserResponseDto(
                userRepository.save(userRequestDto.toEntity())
        );
    }

    @Transactional
    public void withdrawl(UserRequestDto userRequestDto) {
        userRepository.deleteByIdAndPw(userRequestDto.getId(), userRequestDto.getPw());
    }

    public List<UserResponseDto> getUserList() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            userResponseDtoList.add(new UserResponseDto(user));
        }
        return userResponseDtoList;
    }

    public UserResponseDto getUserDetail(int no) {
        return new UserResponseDto(
                userRepository.findByNo(no)
        );
    }

    public UserResponseDto login(UserRequestDto userRequestDto) {
        return new UserResponseDto(
                userRepository.findByIdAndPw(userRequestDto.getId(), userRequestDto.getPw())
        );
    }
}
