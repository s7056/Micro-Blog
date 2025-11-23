package pl.atins.mikroblog.post;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    //get all public posts
    List<Post> findByPrivatePostFalseOrderByCreatedAtDesc();

    //get all public or mine posts by newest
    List<Post> findByPrivatePostFalseOrAuthorIdOrderByCreatedAtDesc(Long authorId);

}