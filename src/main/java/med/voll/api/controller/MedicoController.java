package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.model.medicos.*;

import med.voll.api.model.medicos.direcciones.DatosDireccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaMedico> registrarMedico(@RequestBody
                                              @Valid
                                              DatosRegistroMedico datosRegistroMedico,
                                                UriComponentsBuilder uriComponentsBuilder
                                            ) {
        //
        Medico medico = medicoRepository.save(new Medico(datosRegistroMedico));
        //
        DatosRespuestaMedico datosRespuesta = new
                DatosRespuestaMedico(
                    medico.getId(),
                    medico.getNombre(),
                    medico.getDocumento(),
                    medico.getEmail(),
                    medico.getEspecialidad().toString(),
                    new DatosDireccion(
                            medico.getDireccion().getCalle(),
                            medico.getDireccion().getDistrito(),
                            medico.getDireccion().getCiudad(),
                            medico.getDireccion().getNumero(),
                            medico.getDireccion().getComplemento()
                    )
                );
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();


        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    public Page<ListadoMedicos> listadoMedicos(@PageableDefault(size = 1) Pageable paginacion){
        //return medicoRepository.findAll(paginacion).map(ListadoMedicos::new);
        return medicoRepository.findByActivoTrue(paginacion).map(ListadoMedicos::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarMedico(@RequestBody @Valid DatosActualizarMedico datosActualizarMedico) {
       Medico medico = medicoRepository.getReferenceById(datosActualizarMedico.id());
       medico.actualizar(datosActualizarMedico);
       return ResponseEntity.ok(
               new DatosRespuestaMedico(
                   medico.getId(),
                   medico.getNombre(),
                   medico.getDocumento(),
                   medico.getEmail(),
                   medico.getEspecialidad().toString(),
                   new DatosDireccion(
                           medico.getDireccion().getCalle(),
                           medico.getDireccion().getDistrito(),
                           medico.getDireccion().getCiudad(),
                           medico.getDireccion().getNumero(),
                           medico.getDireccion().getComplemento()
                            )
                ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id) {
        // version soft deleted
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
        return ResponseEntity.noContent().build();
    }


//    public void eliminarMedico(@PathVariable Long id) {
//        Medico medico = medicoRepository.getReferenceById(id);
//        medicoRepository.delete(medico);
    // version hard deleted
//    }
}
