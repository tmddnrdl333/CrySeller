package numble.cryseller.backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_no")
    private Categories categories;

    @Column(length = 45, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String imgLink;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int price;
    @Column(nullable = false)
    private int discountRate;

    @Column(length = 200, nullable = false)
    private String info;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime registerDateTime;
    @Column(nullable = false)
    private LocalDateTime availableDateTime;
}
