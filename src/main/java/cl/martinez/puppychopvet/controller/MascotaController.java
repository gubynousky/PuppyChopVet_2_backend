package cl.martinez.puppychopvet.controller;

import cl.martinez.puppychopvet.model.Mascota;
import cl.martinez.puppychopvet.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {

    @Autowired
    private MascotaService service;

    @GetMapping
    public List<Mascota> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Mascota obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @GetMapping("/dueno/{duenoId}")
    public List<Mascota> obtenerPorDueno(@PathVariable Long duenoId) {
        return service.obtenerPorDueno(duenoId);
    }

    @PostMapping
    public Mascota crear(@RequestBody Mascota mascota) {
        return service.crear(mascota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}