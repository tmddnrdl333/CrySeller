package numble.cryseller.backend.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users {
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
