package cl.martinez.puppychopvet.service;

import cl.martinez.puppychopvet.model.Usuario;
import cl.martinez.puppychopvet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> obtenerTodos() {
        return repository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id));
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = obtenerPorId(id);
        existente.setNombre(usuario.getNombre());
        existente.setTelefono(usuario.getTelefono());
        existente.setEmail(usuario.getEmail());
        existente.setDireccion(usuario.getDireccion());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}