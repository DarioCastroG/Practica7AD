package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transportista")
public class Usuario {
    //Getters y setters
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @Setter
    @Getter
    @Column (name="nombre")
    private String nombre;

    @Setter
    @Getter
    @Column (name="apellidos")
    private String apellidos;

    @Setter
    @Getter
    @Column (name="dni")
    private String dni;

    public Usuario() {

    }

    public Usuario(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

}
