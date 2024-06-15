package med.voll.api.model.medicos;

import med.voll.api.model.medicos.direcciones.DatosDireccion;

public record DatosRespuestaMedico(
        Long    id,
        String  nombre,
        String  documento,
        String  email,
        String  telefono,
        DatosDireccion direccion
) {
}
