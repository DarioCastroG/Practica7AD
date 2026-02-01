package es.transportesamartin.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


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
    @OneToOne
    @JoinColumn(name="transportista_id")
    private Transportista transportista;


    public Vehiculo() {

    }

    public Vehiculo(String matricula, String marca, String modelo, double kilometraje) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public double getKilometraje(){
        return kilometraje;
    }
    public void setKilometraje(double kilometraje){
        this.kilometraje = kilometraje;
    }

}
