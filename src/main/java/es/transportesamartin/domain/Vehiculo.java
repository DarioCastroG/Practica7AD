package es.transportesamartin.domain;


import jakarta.persistence.*;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public long id;

    @Column(name="matricula")
    public String matricula;

    @Column(name="marca")
    public String marca;

    @Column(name="modelo")
    public String modelo;

    @Column(name="kilometraje")
    public double kilometraje;
}
