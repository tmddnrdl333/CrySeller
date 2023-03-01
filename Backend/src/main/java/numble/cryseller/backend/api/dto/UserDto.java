package numble.cryseller.backend.api.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UserDto {
    private int no;
    private String id;
    private String pw;
    private LocalDateTime registerDateTime;

    @QueryProjection
    public UserDto(int no, String id, String pw, LocalDateTime registerDateTime) {
        this.no = no;
        this.id = id;
        this.pw = pw;
        this.registerDateTime = registerDateTime;
    }
}
