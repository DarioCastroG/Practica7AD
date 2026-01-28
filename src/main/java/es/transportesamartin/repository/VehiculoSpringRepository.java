package es.transportesamartin.repository;

import es.transportesamartin.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehiculoSpringRepository extends JpaRepository<Vehiculo, Long> {
    //Metodos CRUD

    //Crear
    Optional<Vehiculo> create(Vehiculo vehiculo);

    //Buscar por id
    Optional<Vehiculo> findById(Long id);

    //Actualizar
    Optional<Vehiculo> update(Long id,Vehiculo vehiculo);

    //Eliminar
    void delete(Vehiculo vehiculo);

}
