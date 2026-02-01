package es.transportesamartin.service;

import es.transportesamartin.domain.Transportista;
import es.transportesamartin.repository.TransportistaSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransportistaService {

    @Autowired
    private TransportistaSpringRepository transportistaRepo;

    public TransportistaService(TransportistaSpringRepository transportistaRepo) {
        this.transportistaRepo = transportistaRepo;
    }

    //Crear un transportista
    @Transactional
    public Transportista create(Transportista transportista) {

        if (transportista.getId() != null) {
            //&& transportista.getDni().isEmpty()
            /*
            if (hasAdminPermissions(roles)) {
                // Admin: check DNI globally
                transportistaRepo.findById(transportista.getId())
                        .ifPresent(a -> {
                            throw new RuntimeException("Ya existe un transportista con ese ID");
                        });
            } else {
                // Transportista: check DNI only for their user
                trasnportistaRepo.findByIdAndUserId(transportista.getId(), userId)
                        .ifPresent(a -> {
                            throw new RuntimeException("Ya existe un transportista con ese ID para tu usuario");
                        });
            }
            */
            transportistaRepo.findById(transportista.getId()).ifPresent(a -> {
                throw new RuntimeException("Ya existe un transportista con ese ID");
            });
        }
        return transportistaRepo.save(transportista);
    }

    //Buscar transportista por id
    public Transportista findById(Long id) {
        return transportistaRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Transportista no existe"));
    }

    public List<Transportista> findAll() {
        return transportistaRepo.findAll();
    }

    //Actualizar transportista
    @Transactional
    public Transportista update(Long id, Transportista transportistaActualizado) {
        Transportista transportista = findById(id);
        transportista.setNombre(transportistaActualizado.getNombre());
        transportista.setApellidos(transportistaActualizado.getApellidos());
        transportista.setDni(transportistaActualizado.getDni());

        return transportistaRepo.save(transportista);
    }



    //Eliminar un transportista
    @Transactional
    public void delete(Long id) {
        transportistaRepo.deleteById(id);
    }

    //Requiere usuario para funcionar

    //Asignar

    //Desasignar
}
