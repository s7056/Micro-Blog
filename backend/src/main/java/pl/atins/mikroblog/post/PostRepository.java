package pl.atins.mikroblog.post;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    //get all public posts
    /*
    Metoda, która pobiera wszystkie wiadomości od wszystkich użytkowników.
    Zastanów się nad parametrem wejściowym metody i typem zwracanym metody. Inaczej
    pobranie pełnej publicznej linii czasu dla całego bloga (Full public timeline)
    */
    List<Post> findByPrivatePostFalseOrderByCreatedAtDesc();

    //get all public or mine posts by newest
    List<Post> findByPrivatePostFalseOrAuthorIdOrderByCreatedAtDesc(Long authorId);



    List<Post> findAllOrderByCreatedAtDesc();
    /*
        Metoda, która pobiera wszystkie wiadomości dla wybranego/konkretnego
    użytkownika. Zastanów się nad parametrem wejściowym metody i typem zwracanym
    metody. Inaczej pobranie linii czasu (Timeline) konkretnego użytkownika.
     */
    List<Post> findByAuthorIdOrderByCreatedAtDesc(Long authorId);


/*
    Metoda, która pobiera wszystkie moje wiadomości (opublikowane przeze mnie) i
    wszystkie wiadomości innych użytkowników których śledzę. Zastanów się nad
    parametrem wejściowym metody i typem zwracanym metody. Inaczej pobranie pełnej
    linii czasu użytkownika (Full timeline)

    SELECT FROM POST



    Metoda która dodaje wiadomość dla użytkownika
            */
}