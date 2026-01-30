package es.transportesamartin.repository;

import es.transportesamartin.domain.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransportistaSpringRepository extends JpaRepository<Transportista, Long> {
    //Crear
    Optional<Transportista> create(Transportista transportista);

    //Buscar por id
    Optional<Transportista> findById(Long id);

    //Actualizar
    Optional<Transportista> update(Long id,Transportista transportista);

    //Eliminar
    void delete(Transportista transportista);

    //Asignar/desasignar vehiculo a transportista

    //Asignar/desasignar ruta a transportista
}
