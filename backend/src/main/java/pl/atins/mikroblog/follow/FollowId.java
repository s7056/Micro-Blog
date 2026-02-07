package pl.atins.mikroblog.follow;

import java.io.Serializable;

public record FollowId(Long followerId, Long followedId) implements Serializable {}