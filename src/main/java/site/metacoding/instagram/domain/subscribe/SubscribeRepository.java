package site.metacoding.instagram.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

    @Modifying // INSERT, DELETE, UPDATE를 네이티브 쿼리로 작성하려면 해당 어노테이션 필요 (디비에 변경을 주는 네이티브 쿼리)
    @Query(value = "INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery = true)
    void mSubscribe(@Param("fromUserId") int fromUserId, @Param("toUserId") int toUserId);

    @Modifying
    @Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId= :toUserId", nativeQuery = true)
    void mUnsubscribe(@Param("fromUserId") int fromUserId, @Param("toUserId") int toUserId);
    // : 변수를 바인딩해서 넣겠다는 문법
}
