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
    @ManyToOne
    @JoinColumn(name="transportista_id")
    private Transportista transportista;

    
    public Ruta() {

    }

    public Ruta(String ptoSalida, String ptoDestino, double distancia, Time tiempoEstimado) {
        this.puntoDeSalida = ptoSalida;
        this.puntoDeDestino = ptoDestino;
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuntoDeSalida() {
        return puntoDeSalida;
    }

    public void setPuntoDeSalida(String puntoDeSalida) {
        this.puntoDeSalida = puntoDeSalida;
    }

    public String getPuntoDeDestino() {
        return puntoDeDestino;
    }

    public void setPuntoDeDestino(String puntoDeDestino) {
        this.puntoDeDestino = puntoDeDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Time getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Time tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }
}
