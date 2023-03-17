package tribess.com.br.biblioteca.BibliotecaDev.service;

import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tribess.com.br.biblioteca.BibliotecaDev.entity.Usuario;
import tribess.com.br.biblioteca.BibliotecaDev.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        if(this.usuarioRepository.existsByDocumentNumber(usuario.getDocumentNumber())){
            throw new EntityExistsException();
        }
        return this.usuarioRepository.save(usuario);
    }
    public Usuario findById(Long id){
        Optional<Usuario> usuarioFound = this.usuarioRepository.findById(id);

        if(usuarioFound.isPresent()){
            return usuarioFound.get();
        }
        return null;
    }

    public Usuario update(Long id, Usuario usuario){
        Usuario usuarioFound = findById(id);

        if(usuarioFound != null){
            usuarioFound.setNome(usuario.getNome());
            usuarioFound.setDocumentNumber(usuario.getDocumentNumber());
            return this.usuarioRepository.save(usuarioFound);
        }
        return null;
    }

    public List<Usuario> list(){
        return this.usuarioRepository.findAll();
    }

    public void delete(Long id){
        Usuario usuarioFound = findById(id);
        if(usuarioFound != null){
            this.usuarioRepository.deleteById(id);
        }
    }
}
