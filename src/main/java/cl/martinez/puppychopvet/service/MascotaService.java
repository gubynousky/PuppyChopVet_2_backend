package cl.martinez.puppychopvet.service;

import cl.martinez.puppychopvet.model.Mascota;
import cl.martinez.puppychopvet.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository repository;

    public List<Mascota> obtenerTodas() {
        return repository.findAll();
    }

    public Mascota obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada: " + id));
    }

    public Mascota crear(Mascota mascota) {
        return repository.save(mascota);
    }

    public List<Mascota> obtenerPorDueno(Long duenoId) {
        return repository.findByDuenoId(duenoId);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}