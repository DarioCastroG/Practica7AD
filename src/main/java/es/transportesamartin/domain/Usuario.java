package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Setter
    @Getter
    @Column (name="nombre")
    private String nombre;

    @Setter
    @Getter
    @Column(nullable = false)
    private String contrasena;

    @Setter
    @Getter
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Setter
    @Getter
    @Column(nullable = false)
    private boolean enabled = true;

    @Setter
    @Getter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="user_id") )
    @Column(name="roles")
    @Enumerated(EnumType.STRING)
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {

    }

    public Usuario(String nombre, String contrasena, String email) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.roles.add(Rol.TRANSPORTISTA);
    }

    public Usuario(String nombre, String contrasena, String email, Rol rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.roles.add(rol);
    }


    public enum Rol {
        ADMIN, TRANSPORTISTA
    }
}
