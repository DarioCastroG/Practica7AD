package es.transportesamartin.controller;

import es.transportesamartin.assembler.RutaAssembler;
import es.transportesamartin.domain.Ruta;
import es.transportesamartin.dto.RutaDTO;
import es.transportesamartin.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ruta")
@CrossOrigin(origins ="*")
public class RutaController {
    @Autowired
    private RutaService rutaService;
    @Autowired
    private RutaAssembler rutaAssembler;

    public RutaController(RutaService rutaService, RutaAssembler rutaAssembler){
        this.rutaService = rutaService;
        this.rutaAssembler = rutaAssembler;
    }

    //Crear ruta (solo Admin)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public RutaDTO create(@RequestBody RutaDTO rutaDTO){
        Ruta ruta = rutaAssembler.toEntity(rutaDTO);
        Ruta nueva = rutaService.create(ruta);

        return rutaAssembler.toDTO(nueva);
    }

    //Actualizar ruta (solo Admin)
    @PutMapping ("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public RutaDTO update(@PathVariable Long id, @RequestBody RutaDTO rutaDTO){
        Ruta rutaExistente = rutaService.findById(id);
        Ruta actualizada = rutaService.update(id,rutaExistente);

        return rutaAssembler.toDTO(actualizada);
    }

    //Eliminar ruta (solo Admin)
    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id){
        rutaService.delete(id);
    }

    //Buscar todos las rutas (solo Admin)
    @GetMapping
    public List<RutaDTO> findAll(){
        return rutaService.findAll().stream().map(rutaAssembler::toDTO).collect(Collectors.toList());
    }

    //Consultar solo el vehiculo asignado al transportista (usuario)
}
