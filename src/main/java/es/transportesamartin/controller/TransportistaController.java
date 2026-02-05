package es.transportesamartin.controller;

import es.transportesamartin.assembler.TransportistaAssembler;
import es.transportesamartin.domain.Transportista;
import es.transportesamartin.dto.TransportistaDTO;
import es.transportesamartin.service.TransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transportista")
@CrossOrigin(origins ="*")
public class TransportistaController {
    @Autowired
    private TransportistaService transportistaService;
    @Autowired
    private TransportistaAssembler transportistaAssembler;

    public TransportistaController(TransportistaService transportistaService, TransportistaAssembler transportistaAssembler) {
        this.transportistaService = transportistaService;
        this.transportistaAssembler = transportistaAssembler;
    }

    //Buscar todos
    @GetMapping
    public List<TransportistaDTO> findAll(){
        return transportistaService.findAll().stream().map(transportistaAssembler::toDTO).collect(Collectors.toList());
    }

    //Crear nuevo transportista (solo el ADMIN)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public TransportistaDTO create(@RequestBody TransportistaDTO transportistaDTO){
        Transportista transportista = transportistaAssembler.toEntity(transportistaDTO);
        Transportista nuevo = transportistaService.create(transportista);

        return transportistaAssembler.toDTO(nuevo);
    }

    //Modificar un transportista existente
    @PutMapping ("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public TransportistaDTO update(@PathVariable Long id, @RequestBody TransportistaDTO transportistaDTO){
        Transportista transportistaExistente = transportistaService.findById(id);
        Transportista actualizado = transportistaService.update(id,transportistaExistente);

        return transportistaAssembler.toDTO(actualizado);
    }

    //Eliminar un transportista
    @DeleteMapping ("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id){
        transportistaService.delete(id);
    }

    //Ver datos propios de un transportista autenticado
    @GetMapping("/{id}")
    public TransportistaDTO findById(@PathVariable Long id){
        return transportistaAssembler.toDTO(transportistaService.findById(id));
    }

    //Asignar/Desasignar transportista a rutas y carreteras
}
