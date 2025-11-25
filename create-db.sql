
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       login VARCHAR(255) NOT NULL UNIQUE,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);


CREATE TABLE posts (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       content VARCHAR(255) NOT NULL,
                       private_post BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMP NOT NULL,
                       user_id BIGINT NOT NULL,
                       CONSTRAINT fk_posts_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE follows (
                         follower_id BIGINT NOT NULL,
                         following_id BIGINT NOT NULL,
                         followed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (follower_id, following_id),
                         CONSTRAINT fk_follows_follower FOREIGN KEY (follower_id) REFERENCES users(id),
                         CONSTRAINT fk_follows_following FOREIGN KEY (following_id) REFERENCES users(id),
                         CONSTRAINT uq_follows UNIQUE (follower_id, following_id)
);


