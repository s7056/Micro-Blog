package pl.atins.mikroblog.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.atins.mikroblog.user.User;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowRepository followRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<?> followUser(
            @PathVariable Long userId,
            @AuthenticationPrincipal User currentUser) {

        if (userId.equals(currentUser.getId())) {
            return ResponseEntity.badRequest().body("Cannot follow yourself");
        }

        if (followRepository.existsByFollowerIdAndFollowingId(currentUser.getId(), userId)) {
            return ResponseEntity.badRequest().body("Already following");
        }

        Follow follow = Follow.builder()
                .followerId(currentUser.getId())
                .followingId(userId)
                .followedAt(LocalDateTime.now())
                .build();

        followRepository.save(follow);
        return ResponseEntity.ok("Now following user " + userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> unfollowUser(
            @PathVariable Long userId,
            @AuthenticationPrincipal User currentUser) {

        if (!followRepository.existsByFollowerIdAndFollowingId(currentUser.getId(), userId)) {
            return ResponseEntity.badRequest().body("Not following this user");
        }

        followRepository.deleteByFollowerIdAndFollowingId(currentUser.getId(), userId);
        return ResponseEntity.ok("Unfollowed user " + userId);
    }

    //todo add service and translate it to users
    @GetMapping("/following")
    public ResponseEntity<List<Follow>> getFollowing(@AuthenticationPrincipal User currentUser) {
        List<Follow> following = followRepository.findByFollowerId(currentUser.getId());
        return ResponseEntity.ok(following);
    }

    @GetMapping("/following/count")
    public ResponseEntity<Long> getFollowingCount(@AuthenticationPrincipal User currentUser) {
        long count = followRepository.countByFollowerId(currentUser.getId());
        return ResponseEntity.ok(count);
    }

    //todo add service and translate it to users
    @GetMapping("/followers")
    public ResponseEntity<List<Follow>> getFollowers(@AuthenticationPrincipal User currentUser) {
        List<Follow> followers = followRepository.findByFollowingId(currentUser.getId());
        return ResponseEntity.ok(followers);
    }
    @GetMapping("/followers/count")
    public ResponseEntity<Long> getFollowersCount(@AuthenticationPrincipal User currentUser) {
        long count = followRepository.countByFollowingId(currentUser.getId());
        return ResponseEntity.ok(count);
    }
}