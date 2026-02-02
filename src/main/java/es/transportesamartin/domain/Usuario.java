package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
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
    private Set<Role> roles = new HashSet<>();

    public Usuario() {

    }

    public Usuario(String nombre, String contrasena, String email) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.roles.add(Role.TRANSPORTISTA);
    }

    public Usuario(String nombre, String contrasena, String email, Role rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.roles.add(rol);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled){
        this.enabled=enabled;
    }

    public Set<Role> getRoles(){
        return roles;
    }

    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public enum Role {
        ADMIN, TRANSPORTISTA
    }
}
