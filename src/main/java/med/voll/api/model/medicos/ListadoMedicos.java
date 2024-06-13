package med.voll.api.model.medicos;

public record ListadoMedicos(
        Long id,
        String nombre,
        Especialidad especialidad,
        String documento,
        String email
) {
    public ListadoMedicos(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEspecialidad(),
                medico.getDocumento(),
                medico.getEmail());
    }
}
