package pl.atins.mikroblog.user.dto;

import jakarta.validation.constraints.*;

public record RegisterRequest(
        @NotBlank String login,
        @NotBlank String name,
        @Email @NotBlank String email,
        @Size(min = 6) @NotBlank String password
) {}