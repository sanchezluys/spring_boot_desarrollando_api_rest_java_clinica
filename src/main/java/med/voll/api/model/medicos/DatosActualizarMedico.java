package med.voll.api.model.medicos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.model.medicos.direcciones.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull Long id,
        String nombre,
        String documento,
        DatosDireccion direccion
)
{
}
