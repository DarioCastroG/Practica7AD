package es.transportesamartin.repository;

import es.transportesamartin.domain.Ruta;
import es.transportesamartin.domain.Transportista;
import es.transportesamartin.domain.Vehiculo;
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

    //Ver los datos del mismo transportista
    Optional<Transportista> findMyself(Transportista transportista);

    //Asignar/desasignar vehiculo a transportista
    void asignarVehiculo(Vehiculo vehiculo);
    void desasignarVehiculo(Vehiculo vehiculo);

    //Asignar/desasignar ruta a transportista
    void asignarRuta(Ruta ruta);
    void desasignarRuta(Ruta ruta);


}
