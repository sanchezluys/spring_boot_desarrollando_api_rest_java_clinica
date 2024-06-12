package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medicos.DatosRegistroMedico;
import med.voll.api.model.medicos.Medico;
import med.voll.api.model.medicos.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        System.out.println("El request llega correctamente: ");
        System.out.println("mostrar parametros: "+ datosRegistroMedico);
        //
        medicoRepository.save(new Medico(datosRegistroMedico));
        //
        System.out.println("Se guardo correctamente");
    }

    @GetMapping
    public List<Medico> listadoMedicos(){
        return medicoRepository.findAll();
    }
}
