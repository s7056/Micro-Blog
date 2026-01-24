package pl.atins.mikroblog.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String email;
}
