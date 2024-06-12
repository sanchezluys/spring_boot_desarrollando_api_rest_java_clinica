package med.voll.api.model.medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.model.medicos.direcciones.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank
        String nombre,

        @NotBlank
        @Email
        String email,

        @Pattern(regexp = "\\d{4,10}")
        String documento,

        @NotNull
        Especialidad especialidad,

        @NotNull
                @Valid
        DatosDireccion direccion
) {
}
