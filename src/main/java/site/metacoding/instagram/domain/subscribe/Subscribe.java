package site.metacoding.instagram.domain.subscribe;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.instagram.domain.user.User;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "subscribe_uk", columnNames = { "fromUserId", "toUserId" })
})
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라간다.
    private Integer id;

    @JoinColumn(name = "fromUserId") // 이렇게 컬럼명 만들어
    @ManyToOne
    private User fromUser; // 구독 하는 유저

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser; // 구독 받는 유저

    private LocalDateTime createDate;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();

    }

}