package med.voll.api.model.medicos;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.medicos.direccion.Direccion;
import org.springframework.web.bind.annotation.RequestBody;


@Table(name = "medicos")
@Entity(name = "Medico")
// uso lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    // soft deleted con un campo
    private boolean activo = false;
    //
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo=true;
        // mapeo

        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizar(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre() != null) {
            this.nombre = datosActualizarMedico.nombre();
        }
        if(datosActualizarMedico.documento() != null){
            this.documento= datosActualizarMedico.documento();
        }
        if(datosActualizarMedico.direccion() != null){
            this.direccion= direccion.actualizar(datosActualizarMedico.direccion());
        }

    }

    public void desactivarMedico() {
        this.activo=false;
    }
}
