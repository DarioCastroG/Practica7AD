package es.transportesamartin.service;

import es.transportesamartin.domain.Transportista;
import es.transportesamartin.domain.Usuario;
import es.transportesamartin.exception.OwnershipException;
import es.transportesamartin.repository.TransportistaSpringRepository;
import es.transportesamartin.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TransportistaService {

    @Autowired
    private TransportistaSpringRepository transportistaRepo;
    @Autowired
    private UserContext userContext;

    public TransportistaService(TransportistaSpringRepository transportistaRepo, UserContext userContext) {
        this.transportistaRepo = transportistaRepo;
        this.userContext = userContext;
    }

    private boolean hasAdminPermissions(Set<Usuario.Role> roles) {
        return roles.contains(Usuario.Role.ADMIN);
    }

    //Crear un transportista
    @Transactional
    public Transportista create(Transportista transportista) {
        Usuario currentUser = userContext.getCurrentUser();
        Set<Usuario.Role> roles = currentUser.getRoles();

        if (transportista.getId() != null) {
            if (hasAdminPermissions(roles)) {
                transportistaRepo.findById(transportista.getId())
                        .ifPresent(a -> {
                            throw new RuntimeException("Ya existe un transportista con ese ID");
                        });
            } else {
                // Transportista: check DNI only for their user
                transportistaRepo.findByIdAndUserId(transportista.getId(), currentUser.getId())
                        .ifPresent(a -> {
                            throw new RuntimeException("Ya existe un transportista con ese ID para tu usuario");
                        });
            }
            transportistaRepo.findById(transportista.getId()).ifPresent(a -> {
                throw new RuntimeException("Ya existe un transportista con ese ID");
            });
        }
        return transportistaRepo.save(transportista);
    }

    //Buscar transportista por id
    public Transportista findById(Long id) {
        Usuario currentUser = userContext.getCurrentUser();
        Set<Usuario.Role> roles = currentUser.getRoles();

        if (hasAdminPermissions(roles)) {
            return transportistaRepo.findById(id)
                    .orElseThrow(() -> new OwnershipException("Transportista no encontrado"));
        } else {
            // ALUMNO solo puede acceder a su propia información
            Long userId = currentUser.getId();
            return transportistaRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Transportista no encontrado"));
        }
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
