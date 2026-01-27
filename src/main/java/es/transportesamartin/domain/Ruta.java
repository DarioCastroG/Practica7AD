package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @Column(name = "puntodesalida")
    private String puntoDeSalida;

    @Column(name = "puntodedestino")
    private String puntoDeDestino;

    public Ruta() {

    }

}
