package com.example.relaciones.Clases;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrumento {

    @Id @GeneratedValue
    private Long id;

    private Date fecha;

    private String nombre;

    private String contenido;

    @ManyToOne
    private Asignatura asignatura;

    private void addToAsignatura (Asignatura a){
        this.asignatura = a;
        a.getInstrumentos().add(this);
    }

    private void deleteAsignatura (Asignatura a){
        this.asignatura = null;
        a.getInstrumentos().remove(this);
    }

    @ManyToMany
    private List<ReferenteEvaluacion> referentes = new ArrayList<>();

}
