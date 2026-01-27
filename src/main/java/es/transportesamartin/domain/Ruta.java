package es.transportesamartin.domain;

import jakarta.persistence.*;

@Entity
@Table(name="ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private long id;

    @Column (name="numerodecarretera")
    private String numeroDeCarretera;

    @Enumerated(value = EnumType.STRING)
    @Column (name="tipodecarretera")
    private Carretera tipoDeCarretera;

    public enum Carretera{
        NACIONAL, COMARCAL, AUTOPISTA, AUTOVIA
    }


}
