package med.voll.api.model.medicos;

import med.voll.api.model.medicos.direcciones.DatosDireccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DatosDireccion direccion
) {
}
