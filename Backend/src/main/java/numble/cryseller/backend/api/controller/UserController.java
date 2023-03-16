package numble.cryseller.backend.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.UserRequestDto;
import numble.cryseller.backend.api.dto.UserResponseDto;
import numble.cryseller.backend.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "회원관리", description = "회원관리 API 입니다.")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "ID와 PW만으로 간단하게 회원가입합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = UserResponseDto.UserInfo.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto.UserInfo> signup(@RequestBody UserRequestDto.IdAndPw idAndPw) {
        UserResponseDto.UserInfo userInfo = userService.signup(idAndPw);
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfo);
    }

    @Operation(summary = "회원탈퇴", description = "ID와 PW를 입력하여 회원을 탈퇴합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @PostMapping("/withdrawal")
    public ResponseEntity<Object> withdrawal(@RequestBody UserRequestDto.IdAndPw idAndPw) {
        userService.withdrawal(idAndPw);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Operation(summary = "회원목록 조회", description = "(관리자)전체 회원의 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDto.UserInfo>> getUserList() {
        List<UserResponseDto.UserInfo> userInfoList = userService.getUserList();
        return ResponseEntity.status(HttpStatus.OK).body(userInfoList);
    }

    @Operation(summary = "회원정보 조회", description = "특정 회원의 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserResponseDto.UserInfo.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping("/{no}")
    public ResponseEntity<UserResponseDto.UserInfo> getUserDetail(@Parameter(name = "no") @PathVariable("no") int no) {
        UserResponseDto.UserInfo userInfo = userService.getUserDetail(no);
        return ResponseEntity.status(HttpStatus.OK).body(userInfo);
    }

    @Operation(summary = "로그인", description = "ID와 PW를 통해 로그인합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserResponseDto.UserInfo.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto.UserInfo> login(@RequestBody UserRequestDto.IdAndPw idAndPw) {
        UserResponseDto.UserInfo userInfo = userService.login(idAndPw);
        return ResponseEntity.status(HttpStatus.OK).body(userInfo);
    }
}
