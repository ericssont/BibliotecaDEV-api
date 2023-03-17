package tribess.com.br.biblioteca.BibliotecaDev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Loan;
import tribess.com.br.biblioteca.BibliotecaDev.repository.LoanRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service

public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan save(Loan loan){
        Long totalPrice= calculaTotal(loan.getInitialDate(),loan.getFinalDate());
        Long dayValue= loan.getBook().getDailyValue();
        loan.setTotalPrice(totalPrice*dayValue);
        return this.loanRepository.save(loan);
    }
    public Loan findById(Long id){
        Optional<Loan> loanFound = this.loanRepository.findById(id);
        if(loanFound.isPresent()){
            return loanFound.get();
        }
        return null;
    }

    public Loan update(Long id, Loan loan){
        Loan loanFound = findById(id);
        if(loanFound != null){
            loanFound.setInitialDate(loan.getInitialDate());
            loanFound.setFinalDate(loan.getFinalDate());
            loanFound.setBook(loan.getBook());
            loanFound.setUsuario(loan.getUsuario());

            Long totalPrice= calculaTotal(loan.getInitialDate(),loan.getFinalDate());
            Long dayValue= loan.getBook().getDailyValue();
            loanFound.setTotalPrice(totalPrice*dayValue);
            return this.loanRepository.save(loanFound);
        }
        return null;
    }

    public List<Loan> list(){
        return this.loanRepository.findAll();
    }

    public void delete(Long id){
        Loan loanFound = findById(id);
        if(loanFound != null){
            this.loanRepository.deleteById(id);
        }
    }

    public long calculaTotal(LocalDate initialDate, LocalDate finalDate){
        return ChronoUnit.DAYS.between(initialDate,finalDate);
    }
}
