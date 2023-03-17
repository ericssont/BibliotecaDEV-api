package tribess.com.br.biblioteca.BibliotecaDev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Usuario;
import tribess.com.br.biblioteca.BibliotecaDev.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return this.usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(this.usuarioService.update(id,usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.usuarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> list(){
        return ResponseEntity.ok(this.usuarioService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        this.usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
