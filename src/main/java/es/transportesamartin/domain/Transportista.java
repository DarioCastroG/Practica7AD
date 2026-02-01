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

    //Getters y setters por si Lombok no funciona
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getDni(){
        return dni;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
}
