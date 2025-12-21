package pl.atins.mikroblog.follow;

import jakarta.persistence.*;
import lombok.*;
import pl.atins.mikroblog.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "follows",
        uniqueConstraints = @UniqueConstraint(columnNames = {"follower_id", "followed_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(FollowId.class)
public class Follow {

    @Id
    @Column(name = "follower_id")
    private Long followerId;

    @Id
    @Column(name = "followed_id")
    private Long followingId;

    @Column(nullable = false)
    private LocalDateTime followedAt;

    @ManyToOne
    @JoinColumn(name = "follower_id", insertable = false, updatable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followed_id", insertable = false, updatable = false)
    private User followed;
}