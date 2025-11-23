package pl.atins.mikroblog.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePostRequest(
        @NotBlank @Size(max = 250) String content,
        Boolean privatePost
) {
    public boolean isPrivatePost() {
        return privatePost != null && privatePost;
    }
}