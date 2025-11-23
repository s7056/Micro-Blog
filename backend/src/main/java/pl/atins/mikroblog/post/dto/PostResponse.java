package pl.atins.mikroblog.post.dto;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String content,
        boolean privatePost,
        LocalDateTime createdAt,
        Long authorId,
        String authorLogin,
        String authorName
) {}