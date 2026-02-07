package pl.atins.mikroblog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.atins.mikroblog.user.dto.UserDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private UserDto mapToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getUsername(), // login
                user.getEmail()
        );
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    public UserDto getCurrentUser(User user) {
        return mapToDto(user);
    }
}
