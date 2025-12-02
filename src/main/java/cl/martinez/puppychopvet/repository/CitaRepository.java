package cl.martinez.puppychopvet.repository;

import cl.martinez.puppychopvet.model.CitaVeterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<CitaVeterinaria, Long> {

    @Query("SELECT c FROM CitaVeterinaria c ORDER BY c.fechaCita ASC, c.horaCita ASC")
    List<CitaVeterinaria> findAllOrdenadas();

    List<CitaVeterinaria> findByConfirmadaFalseOrderByFechaCitaAsc();

    List<CitaVeterinaria> findByConfirmadaTrueOrderByFechaCitaAsc();

    List<CitaVeterinaria> findByTipoServicioOrderByFechaCitaAsc(String tipoServicio);

    List<CitaVeterinaria> findByVeterinarioIdOrderByFechaCitaAsc(Long veterinarioId);

    List<CitaVeterinaria> findByUsuarioIdOrderByFechaCitaDesc(Long usuarioId);

    List<CitaVeterinaria> findByMascotaIdOrderByFechaCitaDesc(Long mascotaId);

    void deleteByConfirmadaTrue();
}