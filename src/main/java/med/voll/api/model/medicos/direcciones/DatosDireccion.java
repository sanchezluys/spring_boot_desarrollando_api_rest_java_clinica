package med.voll.api.model.medicos.direcciones;

public record DatosDireccion(
        String calle,
        String distrito,
        String ciudad,
        String numero,
        String complemento
) {
}
