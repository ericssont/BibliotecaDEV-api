package tribess.com.br.biblioteca.BibliotecaDev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Loan;

@Repository

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
