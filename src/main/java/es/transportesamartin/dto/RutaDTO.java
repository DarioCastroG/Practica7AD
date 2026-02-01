package es.transportesamartin.dto;

import java.sql.Time;

public class RutaDTO {
    private Long id;
    private String puntoDeSalida;
    private String puntoDeEntrada;
    private double distancia;
    private Time tiempoEstimado;


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

    public String getPuntoDeEntrada() {
        return puntoDeEntrada;
    }

    public void setPuntoDeEntrada(String puntoDeEntrada) {
        this.puntoDeEntrada = puntoDeEntrada;
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
}
