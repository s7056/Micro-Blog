package pl.atins.mikroblog.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, FollowId> {

    boolean existsByFollowerIdAndFollowedId(Long followerId, Long followingId);

    void deleteByFollowerIdAndFollowedId(Long followerId, Long followingId);

    // People I follow
    List<Follow> findByFollowerId(Long followerId);

    // My followers
    List<Follow> findByFollowedId(Long followingId);

    // Count followers/following
    long countByFollowedId(Long userId);
    long countByFollowerId(Long userId);
}