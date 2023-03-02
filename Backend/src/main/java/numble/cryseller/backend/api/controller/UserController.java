package numble.cryseller.backend.api.controller;

import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.UserRequestDto;
import numble.cryseller.backend.api.dto.UserResponseDto;
import numble.cryseller.backend.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.signup(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PostMapping("/withdrawl")
    public ResponseEntity<Object> withdrawl(@RequestBody UserRequestDto userRequestDto) {
        userService.withdrawl(userRequestDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUserList() {
        List<UserResponseDto> userResponseDtoList = userService.getUserList();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtoList);
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<UserResponseDto> getUserDetail(@PathVariable int no) {
        UserResponseDto userResponseDto = userService.getUserDetail(no);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.login(userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
}
