package tribess.com.br.biblioteca.BibliotecaDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Boolean existsByDocumentNumber(String documentNumber);
}
