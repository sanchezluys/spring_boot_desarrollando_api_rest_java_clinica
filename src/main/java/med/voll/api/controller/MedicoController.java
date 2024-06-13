package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medicos.DatosRegistroMedico;
import med.voll.api.model.medicos.ListadoMedicos;
import med.voll.api.model.medicos.Medico;
import med.voll.api.model.medicos.MedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


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
    public Page<ListadoMedicos> listadoMedicos(@PageableDefault(size = 1) Pageable paginacion){
        return medicoRepository.findAll(paginacion).map(ListadoMedicos::new);
    }

    @PutMapping
    public void actualizarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        System.out.println("El request llega correctamente: ");
        System.out.println("mostrar parametros: "+ datosRegistroMedico);
        //
        medicoRepository.save(new Medico(datosRegistroMedico));
        //
        System.out.println("Se guardo correctamente");
    }
}
