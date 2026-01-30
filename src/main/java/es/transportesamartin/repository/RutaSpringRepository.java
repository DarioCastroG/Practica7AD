package es.transportesamartin.repository;

import es.transportesamartin.domain.Ruta;
import es.transportesamartin.domain.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
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

    //Listar todas las rutas
    List<Ruta> findAll();

    //Encontrar solo las rutas asociadas al transportista
    Optional<Ruta> findByTransportista(Transportista transportista);
}
