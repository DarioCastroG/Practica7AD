package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ruta")
public class Ruta {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Getter
    @Setter
    @Column(name = "puntodesalida")
    private String puntoDeSalida;

    @Getter
    @Setter
    @Column(name = "puntodedestino")
    private String puntoDeDestino;

    @Getter
    @Setter
    @Column(name = "distancia")
    private double distancia;

    @Getter
    @Setter
    @Column(name = "tiempoestimado")
    private Time tiempoEstimado;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "rutas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Ruta() {

    }

    public Ruta(String ptoSalida, String ptoDestino, double distancia, Time tiempoEstimado) {
        this.puntoDeSalida = ptoSalida;
        this.puntoDeDestino = ptoDestino;
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
    }


}
