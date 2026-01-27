package es.transportesamartin.domain;

import jakarta.persistence.*;

@Entity
@Table(name="ruta")
public class Ruta {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private long id;
}
