package numble.cryseller.backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity(name = "purchases")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private Users users;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_no")
    private Items items;

    @Column(nullable = false)
    private int quantity;

    // TODO: @CreatedDate 이대로 괜찮은가...
    // 내 생각에 이렇게 해도 큰 문제는 없을 것 같은데,
    // 타임딜 특성상 시간의 정확성이 매우 중요하다면...
    // 구매 API에서 찍어준 시간을 여기에 넣어주는게 정확하지 않을까... 하는 생각도 있음.
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime purchaseDateTime;
}
