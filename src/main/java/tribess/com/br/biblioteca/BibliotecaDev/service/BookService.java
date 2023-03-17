package tribess.com.br.biblioteca.BibliotecaDev.service;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Book;
import tribess.com.br.biblioteca.BibliotecaDev.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {

        @Autowired
        private BookRepository bookRepository;

        public Book save(Book book){

            if(this.bookRepository.existsByTitle(book.getTitle())){
                throw new EntityExistsException();
            }
            return this.bookRepository.save(book);
        }
        public Book findById(Long id){
            Optional<Book> bookFound = this.bookRepository.findById(id);

            if(bookFound.isPresent()){
                return bookFound.get();
            }
            return null;
        }

        public Book update(Long id, Book book){
            Book bookFound = findById(id);
            if(bookFound != null){
                bookFound.setTitle(book.getTitle());
                bookFound.setDailyValue(book.getDailyValue());
                return this.bookRepository.save(bookFound);
            }
            return null;
        }

        public List<Book> list(){
            return this.bookRepository.findAll();
        }

        public void delete(Long id){
            Book bookFound = findById(id);
            if(bookFound != null){
                this.bookRepository.deleteById(id);
            }
        }
}
