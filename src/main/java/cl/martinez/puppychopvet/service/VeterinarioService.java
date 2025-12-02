package cl.martinez.puppychopvet.service;

import cl.martinez.puppychopvet.model.Veterinario;
import cl.martinez.puppychopvet.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    public List<Veterinario> obtenerTodos() {
        return repository.findAll();
    }

    public Veterinario obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veterinario no encontrado: " + id));
    }

    public Veterinario crear(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}