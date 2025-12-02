package cl.martinez.puppychopvet.controller;

import cl.martinez.puppychopvet.model.Veterinario;
import cl.martinez.puppychopvet.service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin(origins = "*")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    @GetMapping
    public List<Veterinario> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Veterinario obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Veterinario crear(@RequestBody Veterinario veterinario) {
        return service.crear(veterinario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}