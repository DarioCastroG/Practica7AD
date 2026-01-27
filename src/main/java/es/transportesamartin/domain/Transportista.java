package es.transportesamartin.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "transportista")
public class Transportista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @Column (name="nombre")
    private String nombre;

    @Column (name="apellidos")
    private String apellidos;

    @Column (name="dni")
    private String dni;


}
