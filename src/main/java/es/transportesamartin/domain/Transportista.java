package es.transportesamartin.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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


    @Getter
    @Setter
    @OneToOne(mappedBy="vehiculos")
    private Vehiculo vehiculo;

    @Getter
    @Setter
    @OneToMany(mappedBy="ruta", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Ruta> rutas = new ArrayList<>();

    public Transportista(){

    }

    public Transportista(String nombre, String apellidos, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
}
