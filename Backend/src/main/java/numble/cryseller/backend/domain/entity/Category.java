package numble.cryseller.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "categories")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    @Id
    @Column(nullable = false)
    private int no;
    @Column(length = 20, nullable = false)
    private String name;
}
