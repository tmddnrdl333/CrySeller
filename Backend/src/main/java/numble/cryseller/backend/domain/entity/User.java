package numble.cryseller.backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column(length = 30, nullable = false)
    private String id;
    @Column(length = 30, nullable = false)
    private String pw;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime registerDateTime;
}
