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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Instrumento> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(List<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public List<ReferenteEvaluacion> getReferentes() {
        return referentes;
    }

    public void setReferentes(List<ReferenteEvaluacion> referentes) {
        this.referentes = referentes;
    }

    @ManyToMany(mappedBy = "asignaturas")
    private List<Alumno> alumnos = new ArrayList<>();

    @OneToMany(mappedBy = "asignatura")
    private List<Instrumento> instrumentos = new ArrayList<>();

    @OneToMany(mappedBy = "asignatura")
    private List<ReferenteEvaluacion> referentes = new ArrayList<>();

}
