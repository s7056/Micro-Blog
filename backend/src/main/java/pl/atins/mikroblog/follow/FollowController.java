package pl.atins.mikroblog.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.atins.mikroblog.user.User;
import pl.atins.mikroblog.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @PostMapping("/{userId}")
    public ResponseEntity<?> followUser(
            @PathVariable Long userId,
            @AuthenticationPrincipal User currentUser) {
        if (userId.equals(currentUser.getId())) {
            return ResponseEntity.badRequest().body("Cannot follow yourself");
        }
        if (followRepository.existsByFollowerIdAndFollowedId(currentUser.getId(), userId)) {
            return ResponseEntity.badRequest().body("Already following");
        }
        var followed = userRepository.findById(userId).get();
        Follow follow = Follow.builder()
                .followerId(currentUser.getId())
                .followedId(userId)
                .followedAt(LocalDateTime.now())
                .follower(currentUser)
                .followed(followed)
                .build();

        followRepository.save(follow);
        return ResponseEntity.ok("Now following user " + userId);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> unfollowUser(
            @PathVariable Long userId,
            @AuthenticationPrincipal User currentUser) {

        if (!followRepository.existsByFollowerIdAndFollowedId(currentUser.getId(), userId)) {
            return ResponseEntity.badRequest().body("Not following this user");
        }
        followRepository.deleteByFollowerIdAndFollowedId(currentUser.getId(), userId);
        return ResponseEntity.ok("Unfollowed user " + userId);
    }

    //todo add service and translate it to users
    @GetMapping("/following")
    public ResponseEntity<List<User>> getFollowing(@AuthenticationPrincipal User currentUser) {
        List<Follow> following = followRepository.findByFollowerId(currentUser.getId());
        var followedUsers = following.stream().map(Follow::getFollowed).toList();
        return ResponseEntity.ok(followedUsers);
    }

    @GetMapping("/following/count")
    public ResponseEntity<Long> getFollowingCount(@AuthenticationPrincipal User currentUser) {
        long count = followRepository.countByFollowerId(currentUser.getId());
        return ResponseEntity.ok(count);
    }

    //todo add service and translate it to users
    @GetMapping("/followers")
    public ResponseEntity<List<User>> getFollowers(@AuthenticationPrincipal User currentUser) {
        List<Follow> follows = followRepository.findByFollowedId(currentUser.getId());
        var followers = follows.stream().map(Follow::getFollower).toList();
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/followers/count")
    public ResponseEntity<Long> getFollowersCount(@AuthenticationPrincipal User currentUser) {
        long count = followRepository.countByFollowedId(currentUser.getId());
        return ResponseEntity.ok(count);
    }

}