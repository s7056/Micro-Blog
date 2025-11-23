package pl.atins.mikroblog.post;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.atins.mikroblog.post.dto.CreatePostRequest;
import pl.atins.mikroblog.post.dto.PostResponse;
import pl.atins.mikroblog.user.User;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    //todo add service later
    private final PostRepository postRepository;

    // CREATE POST
    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @Valid @RequestBody CreatePostRequest request,
            @AuthenticationPrincipal User currentUser) {

        Post post = Post.builder()
                .content(request.content())
                .privatePost(request.isPrivatePost())
                .author(currentUser)
                .build();

        Post saved = postRepository.save(post);

        PostResponse response = toResponse(saved);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts(@AuthenticationPrincipal User currentUser) {
        List<Post> posts;

        if (currentUser == null) {
            // Not logged only public posts
            posts = postRepository.findByPrivatePostFalseOrderByCreatedAtDesc();
        } else {
            // Logged in: public + own private posts
            posts = postRepository.findByPrivatePostFalseOrAuthorIdOrderByCreatedAtDesc(currentUser.getId());
        }

        return ResponseEntity.ok(posts.stream().map(this::toResponse).toList());
    }

    // Entity DTO converter
    private PostResponse toResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getContent(),
                post.isPrivatePost(),
                post.getCreatedAt(),
                post.getAuthor().getId(),
                post.getAuthor().getLogin(),
                post.getAuthor().getName()
        );
    }

}