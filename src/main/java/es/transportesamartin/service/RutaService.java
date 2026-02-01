package es.transportesamartin.service;

import es.transportesamartin.domain.Ruta;
import es.transportesamartin.domain.Transportista;
import es.transportesamartin.repository.RutaSpringRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    @Autowired
    private RutaSpringRepository rutaRepo;

    public RutaService(RutaSpringRepository rutaRepo){
        this.rutaRepo = rutaRepo;
    }

    //Crear ruta
    @Transactional
    public Ruta create(Ruta ruta){
        if(ruta.getId()!=null){
            rutaRepo.findById(ruta.getId()).ifPresent(a -> {
                throw new RuntimeException("Ya existe una ruta con ese ID");
            });
        }

        return rutaRepo.save(ruta);
    }

    //Buscar ruta por id
    public Ruta findById(Long id){
        return rutaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Esa ruta no existe o no tienes acceso a ella"));
    }

    //Buscar todas las rutas
    public List<Ruta> findAll(){
        return rutaRepo.findAll();
    }

    //Actualizar ruta
    @Transactional
    public Ruta update(Long id, Ruta rutaActualizada) {
        Ruta ruta = findById(id);
        ruta.setPuntoDeSalida(rutaActualizada.getPuntoDeSalida());
        ruta.setPuntoDeDestino(rutaActualizada.getPuntoDeDestino());
        ruta.setDistancia(rutaActualizada.getDistancia());
        ruta.setTiempoEstimado(rutaActualizada.getTiempoEstimado());

        return rutaRepo.save(ruta);
    }



    //Eliminar una ruta
    @org.springframework.transaction.annotation.Transactional
    public void delete(Long id) {
        rutaRepo.deleteById(id);
    }

    //Requiere usuario para funcionar

    //Asignar un transportista

    //Desasignar transportista
}
