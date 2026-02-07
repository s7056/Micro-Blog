package pl.atins.mikroblog.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /*
    Metoda, która pobiera użytkownika po loginie
     */
    Optional<User> findByLogin(String login);

    /*
    Metoda, która rejestruje/dodaje nowego użytkownika
    nie jest tu potrzebna - już jest wbudowana w repo.
    */
//    @Override
//    User save(User user);

    boolean existsByLogin(String login);
    boolean existsByEmail(String email);

    @Override
    List<User> findAll();

}
