package es.transportesamartin.repository;

import es.transportesamartin.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSpringRepository extends JpaRepository<Usuario, Long> {
    //Métodos CRUD
}
