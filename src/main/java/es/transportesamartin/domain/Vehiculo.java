package es.transportesamartin.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public Long id;

    @Getter
    @Setter
    @Column(name="matricula")
    public String matricula;

    @Getter
    @Setter
    @Column(name="marca")
    public String marca;

    @Getter
    @Setter
    @Column(name="modelo")
    public String modelo;

    @Getter
    @Setter
    @Column(name="kilometraje")
    public double kilometraje;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transportista_id")
    private Transportista transportista;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "vehiculo_ruta",
            joinColumns = @JoinColumn(name = "vehiculo_id"),
            inverseJoinColumns = @JoinColumn(name = "ruta_id")
    )
    private List<Ruta> rutas = new ArrayList<>();

    public Vehiculo() {

    }

    public Vehiculo(String matricula, String marca, String modelo, double kilometraje) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }


}
