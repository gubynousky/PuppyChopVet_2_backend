package cl.martinez.puppychopvet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String raza;
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "dueno_id", nullable = false)
    private Usuario dueno;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CitaVeterinaria> citas = new ArrayList<>();

    public Mascota() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Usuario getDueno() {
        return dueno;
    }

    public void setDueno(Usuario dueno) {
        this.dueno = dueno;
    }

    public List<CitaVeterinaria> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaVeterinaria> citas) {
        this.citas = citas;
    }
}