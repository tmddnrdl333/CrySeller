package numble.cryseller.backend.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.cryseller.backend.domain.entity.User;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String id;
    private String pw;

    @Builder
    public UserRequestDto(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    // RequestDto -> Entity
    public User toEntity() {
        return User.builder()
                .id(id)
                .pw(pw)
                .build();
    }

}
