package com.example.relaciones.Clases;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asignatura {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private int horas;

    private String descripcion;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Alumno> alumnos = new ArrayList<>();

    @OneToMany(mappedBy = "asignatura")
    private List<Instrumento> instrumentos = new ArrayList<>();

    @OneToMany(mappedBy = "asignatura")
    private List<ReferenteEvaluacion> referentes = new ArrayList<>();

}
