package es.transportesamartin.repository;

import es.transportesamartin.domain.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RutaSpringRepository extends JpaRepository<Ruta, Long> {
    //Metodos CRUD

    //Crear
    Optional<Ruta> create(Ruta ruta);

    //Buscar por id
    Optional<Ruta> findById(Long id);

    //Actualizar
    Optional<Ruta> update(Long id,Ruta ruta);

    //Eliminar
    void delete(Ruta ruta);
}
