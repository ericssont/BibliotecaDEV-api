package tribess.com.br.biblioteca.BibliotecaDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Book;

@Repository

public interface BookRepository extends JpaRepository<Book,Long> {

    Boolean existsByTitle(String title);
}