package med.voll.api.model.medicos;

public record ListadoMedicos(
        String nombre,
        Especialidad especialidad,
        String documento,
        String email
) {
    public ListadoMedicos(Medico medico) {
        this(
                medico.getNombre(),
                medico.getEspecialidad(),
                medico.getDocumento(),
                medico.getEmail());
    }
}
