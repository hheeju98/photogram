package site.metacoding.instagram.domain.image;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query(value = "SELECT * FROM image WHERE userId IN (SELECT toUserId FROM subscribe WHERE fromUserId = :principalId)", nativeQuery = true)
    Page<Image> mStory(@Param("principalId") int principalId, Pageable pageable);
}
