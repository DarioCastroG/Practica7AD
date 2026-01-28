package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transportista")
public class Transportista {

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
    @Column(name="apellidos")
    private String apellidos;

    @Setter
    @Getter
    @Column (name="dni")
    private String dni;

    public Transportista() {

    }

    public Transportista(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
}
