package es.transportesamartin.domain;


import jakarta.persistence.*;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public long id;

}
