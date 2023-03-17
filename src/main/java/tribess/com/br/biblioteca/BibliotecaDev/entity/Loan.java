package tribess.com.br.biblioteca.BibliotecaDev.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate initialDate;
    @Column
    private LocalDate finalDate;
    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;
    @OneToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
    @Column
    private Long totalPrice;

}
