package es.transportesamartin.controller;


import es.transportesamartin.assembler.VehiculoAssembler;
import es.transportesamartin.domain.Vehiculo;
import es.transportesamartin.dto.VehiculoDTO;
import es.transportesamartin.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin(origins ="*")
public class VehiculoController {
    @Autowired
    private VehiculoService vehiculoService;
    private VehiculoAssembler vehiculoAssembler;

    public VehiculoController(VehiculoService vehiculoService, VehiculoAssembler vehiculoAssembler){
        this.vehiculoService = vehiculoService;
        this.vehiculoAssembler = vehiculoAssembler;
    }

    //Crear vehículo
    @PostMapping
    public VehiculoDTO create(@RequestBody VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = vehiculoAssembler.toEntity(vehiculoDTO);
        Vehiculo nuevo = vehiculoService.create(vehiculo);
        return vehiculoAssembler.toDTO(vehiculo);
    }

    //Actualizar ruta (solo Admin)
    @PutMapping ("/{id}")
    public VehiculoDTO update(@PathVariable Long id, @RequestBody VehiculoDTO vehiculoDTO){
        Vehiculo vehiculoExistente = vehiculoService.findById(id);
        Vehiculo actualizado = vehiculoService.update(id,vehiculoExistente);

        return vehiculoAssembler.toDTO(actualizado);
    }

    //Eliminar ruta (solo Admin)
    @DeleteMapping
    public void delete(@PathVariable Long id){
        vehiculoService.delete(id);
    }

    //Buscar todos las rutas (solo Admin)
    @GetMapping
    public List<VehiculoDTO> findAll(){
        return vehiculoService.findAll().stream().map(vehiculoAssembler::toDTO).collect(Collectors.toList());
    }

    //Ver vehículo solo del transportista
}
