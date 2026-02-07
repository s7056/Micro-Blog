package pl.atins.mikroblog.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.atins.mikroblog.user.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    /*
    Pobranie pełnej linii czasu użytkownika (Full timeline)

        Metoda, która pobiera wszystkie moje wiadomości (opublikowane przeze mnie) i
        wszystkie wiadomości innych użytkowników których śledzę.
     */

    @Query("""
            SELECT p FROM Post p
            WHERE p.author = :myUser
               OR p.author IN (
                   SELECT f.followed FROM Follow f
                   WHERE f.follower = :myUser
               )
            ORDER BY p.createdAt DESC
            """)
    List<Post> findAllMyPostsAndFollowedUsersPosts(@Param("myUser") User myUser);

    //get all public posts
    /*
    Metoda, która pobiera wszystkie wiadomości od wszystkich użytkowników.
    pobranie pełnej publicznej linii czasu dla całego bloga (Full public timeline)
    */
    List<Post> findByPrivatePostFalseOrderByCreatedAtDesc();

    //get all public or mine posts by newest
    List<Post> findByPrivatePostFalseOrAuthorIdOrderByCreatedAtDesc(Long authorId);

    //    List<Post> findAllOrderByCreatedAtDescending();
    /*
        Metoda, która pobiera wszystkie wiadomości dla wybranego/konkretnego
 Inaczej pobranie linii czasu (Timeline) konkretnego użytkownika.
     */
    List<Post> findByAuthorIdOrderByCreatedAtDesc(Long authorId);

    /*
    Metoda która dodaje wiadomość dla użytkownika
            */
    //jest już wbudowana w interfejs


    @Query( """
    SELECT DISTINCT p
    FROM Post p
    LEFT JOIN Follow f
      ON f.followed = p.author AND f.follower = :myUser
    LEFT JOIN Follow m
      ON m.follower = p.author AND m.followed = :myUser
    WHERE
      p.author = :myUser
      OR (
        f.followedId IS NOT NULL
        AND (p.privatePost = false OR m.followedId IS NOT NULL)
      )
    ORDER BY p.createdAt DESC
  """
    )
    List<Post> findPersonalFeed2(@Param("myUser") User myUser);


    @Query(
            """
                SELECT DISTINCT p
                FROM Post p
                LEFT JOIN Follow f
                  ON f.follower = :myUser AND f.followed = p.author
                LEFT JOIN Follow m
                  ON m.follower = p.author AND m.followed = :myUser
                WHERE
                  p.author = :myUser
                  OR (
                    f.followerId IS NOT NULL
                    AND (p.privatePost = false OR m.followerId IS NOT NULL)
                  )
                ORDER BY p.createdAt DESC
              """

    )
    List<Post> findPersonalFeed(@Param("myUser") User myUser);


    List<Post> findAllByOrderByCreatedAtDesc();
}