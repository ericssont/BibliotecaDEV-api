package tribess.com.br.biblioteca.BibliotecaDev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Book;
import tribess.com.br.biblioteca.BibliotecaDev.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book save(@RequestBody Book book){
        return this.bookService.save(book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        return ResponseEntity.ok(this.bookService.update(id,book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.bookService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Book>> list(){
        return ResponseEntity.ok(this.bookService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
