package es.transportesamartin.service;

import es.transportesamartin.domain.Vehiculo;
import es.transportesamartin.repository.VehiculoSpringRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public class VehiculoService {
    @Autowired
    private VehiculoSpringRepository vehiculoRepo;

    public VehiculoService(VehiculoSpringRepository vehiculoRepo){
        this.vehiculoRepo = vehiculoRepo;
    }

    //Crear ruta
    @Transactional
    public Vehiculo create(Vehiculo vehiculo){
        if(vehiculo.getId()!=null){
            vehiculoRepo.findById(vehiculo.getId()).ifPresent(a -> {
                throw new RuntimeException("Ya existe una ruta con ese ID");
            });
        }

        return vehiculoRepo.save(vehiculo);
    }

    //Buscar ruta por id
    public Vehiculo findById(Long id){
        return vehiculoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Esa ruta no existe o no tienes acceso a ella"));
    }

    //Buscar todas las rutas
    public List<Vehiculo> findAll(){
        return vehiculoRepo.findAll();
    }

    //Actualizar ruta
    @Transactional
    public Vehiculo update(Long id, Vehiculo vehiculoActualizado) {
        Vehiculo vehiculo = findById(id);
        vehiculo.setMatricula(vehiculoActualizado.getMatricula());
        vehiculo.setMarca(vehiculoActualizado.getMarca());
        vehiculo.setModelo(vehiculoActualizado.getModelo());
        vehiculo.setKilometraje(vehiculoActualizado.getKilometraje());

        return vehiculoRepo.save(vehiculo);
    }



    //Eliminar una ruta
    @Transactional
    public void delete(Long id) {
        vehiculoRepo.deleteById(id);
    }

    //Requiere usuario para funcionar

    //Asignar un transportista

    //Desasignar transportista
}
