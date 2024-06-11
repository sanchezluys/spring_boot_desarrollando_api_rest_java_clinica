package med.voll.api.controller;

import med.voll.api.model.medicos.DatosRegistroMedico;
import med.voll.api.model.medicos.Medico;
import med.voll.api.model.medicos.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroMedico datosRegistroMedico) {
        System.out.println("El request llega correctamente: ");
        System.out.println("mostrar parametros: "+ datosRegistroMedico);
        //
        medicoRepository.save(new Medico(datosRegistroMedico));
        //
        System.out.println("Se guardo correctamente");
    }
}
