package es.transportesamartin.repository;

import es.transportesamartin.domain.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportistaSpringRepository extends JpaRepository<Transportista, Long> {
    //CRUD
}
