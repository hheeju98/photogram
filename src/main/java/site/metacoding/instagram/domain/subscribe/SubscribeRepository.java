package site.metacoding.instagram.domain.subscribe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribeRepository extends JpaRepository<Subscribe, Integer> {

    @Modifying // INSERT, DELETE, UPDATE를 네이티브 쿼리로 작성하려면 해당 어노테이션 필요 (디비에 변경을 주는 네이티브 쿼리)
    @Query(value = "INSERT INTO subscribe(fromUserId, toUserId, createDate) VALUES(:fromUserId, :toUserId, now())", nativeQuery = true)
    void mSubscribe(@Param("fromUserId") Integer fromUserId, @Param("toUserId") Integer toUserId);

    @Modifying
    @Query(value = "DELETE FROM subscribe WHERE fromUserId = :fromUserId AND toUserId= :toUserId", nativeQuery = true)
    void mUnsubscribe(@Param("fromUserId") Integer fromUserId, @Param("toUserId") Integer toUserId);
    // : 변수를 바인딩해서 넣겠다는 문법

    @Query(value = "SELECT COUNT(*) FROM subscribe WHERE fromUserId = :principalId AND toUserId = :pageUserId", nativeQuery = true)
    Integer mSubscribeState(@Param("principalId") Integer principalId, @Param("pageUserId") Integer pageUserId);

    @Query(value = "SELECT COUNT(*) FROM subscribe WHERE fromUserId = :pageUserId", nativeQuery = true)
    Integer mSubscribeCount(@Param("pageUserId") Integer pageUserId);
}
