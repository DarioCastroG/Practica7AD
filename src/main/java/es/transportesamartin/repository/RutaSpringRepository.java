package es.transportesamartin.repository;

import es.transportesamartin.domain.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RutaSpringRepository extends JpaRepository<Ruta, Long> {
    //CRUD
}
