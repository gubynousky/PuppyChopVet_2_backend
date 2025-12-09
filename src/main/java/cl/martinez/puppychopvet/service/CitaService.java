package cl.martinez.puppychopvet.service;

import cl.martinez.puppychopvet.model.CitaVeterinaria;
import cl.martinez.puppychopvet.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository repository;

    public List<CitaVeterinaria> obtenerTodas() {
        return repository.findAllOrdenadas();
    }

    public CitaVeterinaria obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada: " + id));
    }

    public CitaVeterinaria crear(CitaVeterinaria cita) {
        return repository.save(cita);
    }

    public CitaVeterinaria actualizar(Long id, CitaVeterinaria cita) {
        CitaVeterinaria existente = obtenerPorId(id);
        existente.setFechaCita(cita.getFechaCita());
        existente.setHoraCita(cita.getHoraCita());
        existente.setTipoServicio(cita.getTipoServicio());
        existente.setMotivo(cita.getMotivo());
        existente.setPrioridad(cita.getPrioridad());
        existente.setNotas(cita.getNotas());
        existente.setNotificacionActiva(cita.getNotificacionActiva());
        existente.setConfirmada(cita.getConfirmada());
        return repository.save(existente);

    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<CitaVeterinaria> obtenerPendientes() {
        return repository.findByConfirmadaFalseOrderByFechaCitaAsc();
    }

    public List<CitaVeterinaria> obtenerConfirmadas() {
        return repository.findByConfirmadaTrueOrderByFechaCitaAsc();
    }

    public CitaVeterinaria confirmar(Long id) {
        CitaVeterinaria cita = obtenerPorId(id);
        cita.setConfirmada(true);
        return repository.save(cita);
    }

    public List<CitaVeterinaria> obtenerPorTipo(String tipo) {
        return repository.findByTipoServicioOrderByFechaCitaAsc(tipo);
    }

    public List<CitaVeterinaria> obtenerPorVeterinario(Long veterinarioId) {
        return repository.findByVeterinarioIdOrderByFechaCitaAsc(veterinarioId);
    }

    public List<CitaVeterinaria> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioIdOrderByFechaCitaDesc(usuarioId);
    }

    public List<CitaVeterinaria> obtenerPorMascota(Long mascotaId) {
        return repository.findByMascotaIdOrderByFechaCitaDesc(mascotaId);
    }

    @Transactional
    public void eliminarConfirmadas() {
        repository.deleteByConfirmadaTrue();
    }
}