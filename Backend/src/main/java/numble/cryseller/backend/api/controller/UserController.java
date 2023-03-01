package numble.cryseller.backend.api.controller;

import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.UserRequest;
import numble.cryseller.backend.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserRequest.UserIdAndPw userIdAndPw) {
        return userService.signup(userIdAndPw);
    }

    @PostMapping("/withdrawl")
    public ResponseEntity<?> withdrawl(@RequestBody UserIdAndPw userIdAndPw) {
        return userService.withdrawl(userIdAndPw);
    }

    @GetMapping
    public ResponseEntity<?> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<?> getUserDetail(@PathVariable int userNo) {
        return userService.getUserDetail(userNo);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserIdAndPw userIdAndPw) {
        return userService.login(userIdAndPw);
    }
}
