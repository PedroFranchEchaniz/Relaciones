package com.example.relaciones.Clases;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {

    @EmbeddedId
    private CalificacionPK calificacionPK = new CalificacionPK();
    private double puntuacion;

    public Calificacion(Alumno a, Asignatura as, Instrumento ins, ReferenteEvaluacion ref, double puntuacion){
        this.alumno = a;
        this.asignatura = as;
        this.instrumento = ins;
        this.referenteEvaluacion = ref;
        this.puntuacion = puntuacion;
    }

    @ManyToOne
    @MapsId("alumno_id")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @MapsId("asginatura_id")
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ManyToOne
    @MapsId("instrumento_id")
    @JoinColumn(name = "instrumento_id")
    private Instrumento instrumento;

    @ManyToOne
    @MapsId("referente_id")
    @JoinColumn(name = "referente_id")
    private ReferenteEvaluacion referenteEvaluacion;

    public void addToAlumno(Alumno a){
        a.getCalificaciones().add(this);
        this.alumno = a;
    }

    public void removeAlumno (Alumno a){
        a.getCalificaciones().remove(this);
        this.alumno=null;
    }

}
