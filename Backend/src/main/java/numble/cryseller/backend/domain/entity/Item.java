package numble.cryseller.backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name = "items")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_no", nullable = false)
    private Category category;

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
