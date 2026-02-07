package pl.atins.mikroblog.follow;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, FollowId> {

    /*
     Metoda - Sprawdzenie czy inny użytkownik jest na mojej liście śledzonych.
    Odczyt pary “follower” i “followee”
     */
    boolean existsByFollowerIdAndFollowedId(Long followerId, Long followedId);

    /*
    Usunięcie innego użytkownika ze śledzonych przez obecnie
    zalogowanego użytkownika. Usunięcie pary “follower” i “followee”
     */
    void deleteByFollowerIdAndFollowedId(Long followerId, Long followedId);

    // People I follow
    List<Follow> findByFollowerId(Long followerId);

    // My followers
    List<Follow> findByFollowedId(Long followedId);

    // Count followers/following
    long countByFollowedId(Long userId);
    long countByFollowerId(Long userId);

    // WBUDOWANA w interfejs
    /*
    Metoda - Dodanie innego użytkownika do śledzonych
    przez obecnie    zalogowanego użytkownika. Powstaje para “follower” i “followee”
     */
    //    @Override
    //    Follow save(Follow follow);
    /*
    5. W interfejsie FollowerDao deklarujemy następujące metody:

    a.    Metoda - Dodanie innego użytkownika do śledzonych
            przez obecnie    zalogowanego użytkownika. Powstaje para “follower” i “followee”

    b.    Metoda - Usunięcie innego użytkownika ze śledzonych przez obecnie
    zalogowanego użytkownika. Usunięcie pary “follower” i “followee”

    c.   Metoda - Sprawdzenie czy inny użytkownik jest na mojej liście śledzonych.
            Odczyt pary “follower” i “followee”
     */
}