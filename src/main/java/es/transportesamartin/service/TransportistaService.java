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



    @Transactional
    public Transportista create(Transportista transportista) {

        if (transportista.getDni() != null && !transportista.getDni().isEmpty()) {
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
                throw new RuntimeException("Ya existe un transportista con ese DNI");
            });
        }
        return transportistaRepo.save(transportista);
    }

    public List<Transportista> findAll() {
        return transportistaRepo.findAll();
    }

    @Transactional
    public Transportista update(Transportista transportista) {
        if (transportistaRepo.findById(transportista.getId()) == null || transportista.getDni().isEmpty()) {

            throw new RuntimeException("Ya existe un transportista con ese DNI");

        }
        return transportistaRepo.save(transportista);
    }


}
