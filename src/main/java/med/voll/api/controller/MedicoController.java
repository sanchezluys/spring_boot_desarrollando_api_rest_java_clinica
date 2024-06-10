package med.voll.api.controller;

import med.voll.api.model.medicos.DatosRegistroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        System.out.println("El request llega correctamente: ");
        System.out.println("mostrar parametros: "+ datosRegistroMedico);
    }
}
