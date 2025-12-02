package cl.martinez.puppychopvet.controller;

import cl.martinez.puppychopvet.model.CitaVeterinaria;
import cl.martinez.puppychopvet.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService service;

    @GetMapping
    public List<CitaVeterinaria> obtenerTodas() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public CitaVeterinaria obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public CitaVeterinaria crear(@RequestBody CitaVeterinaria cita) {
        return service.crear(cita);
    }

    @PutMapping("/{id}")
    public CitaVeterinaria actualizar(@PathVariable Long id, @RequestBody CitaVeterinaria cita) {
        return service.actualizar(id, cita);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return Map.of("mensaje", "Cita eliminada");
    }

    @GetMapping("/pendientes")
    public List<CitaVeterinaria> obtenerPendientes() {
        return service.obtenerPendientes();
    }

    @GetMapping("/confirmadas")
    public List<CitaVeterinaria> obtenerConfirmadas() {
        return service.obtenerConfirmadas();
    }

    @PatchMapping("/{id}/confirmar")
    public CitaVeterinaria confirmar(@PathVariable Long id) {
        return service.confirmar(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<CitaVeterinaria> obtenerPorTipo(@PathVariable String tipo) {
        return service.obtenerPorTipo(tipo);
    }

    @GetMapping("/veterinario/{veterinarioId}")
    public List<CitaVeterinaria> obtenerPorVeterinario(@PathVariable Long veterinarioId) {
        return service.obtenerPorVeterinario(veterinarioId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<CitaVeterinaria> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return service.obtenerPorUsuario(usuarioId);
    }

    @GetMapping("/mascota/{mascotaId}")
    public List<CitaVeterinaria> obtenerPorMascota(@PathVariable Long mascotaId) {
        return service.obtenerPorMascota(mascotaId);
    }

    @DeleteMapping("/confirmadas")
    public Map<String, String> eliminarConfirmadas() {
        service.eliminarConfirmadas();
        return Map.of("mensaje", "Citas confirmadas eliminadas");
    }

    @GetMapping("/estadisticas")
    public Map<String, Long> estadisticas() {
        long pendientes = service.obtenerPendientes().size();
        long confirmadas = service.obtenerConfirmadas().size();
        return Map.of(
                "pendientes", pendientes,
                "confirmadas", confirmadas,
                "total", pendientes + confirmadas
        );
    }
}