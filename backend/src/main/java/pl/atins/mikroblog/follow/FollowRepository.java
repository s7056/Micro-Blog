package pl.atins.mikroblog.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, FollowId> {

    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);

    void deleteByFollowerIdAndFollowingId(Long followerId, Long followingId);

    // People I follow
    List<Follow> findByFollowerId(Long followerId);

    // My followers
    List<Follow> findByFollowingId(Long followingId);

    // Count followers/following
    long countByFollowingId(Long userId);
    long countByFollowerId(Long userId);
}