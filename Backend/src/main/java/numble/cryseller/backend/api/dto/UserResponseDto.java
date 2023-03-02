package numble.cryseller.backend.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.cryseller.backend.domain.entity.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private int no;
    private LocalDateTime registerDateTime;

    // Entity -> ResponseDto
    public UserResponseDto(User user) {
        this.no = user.getNo();
        this.registerDateTime = user.getRegisterDateTime();
    }

}
