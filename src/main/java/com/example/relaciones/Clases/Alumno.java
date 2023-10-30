package com.example.relaciones.Clases;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String apellidos;

    private String email;

    private String telefono;

    private Date fechaNacimiento;


    @ManyToMany
    @JoinTable(name = "Matricula",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "asignaturas_id"))
    private List<Asignatura> asignaturas = new ArrayList<>();

    public void addAsignatura(Asignatura a){
        this.asignaturas.add(a);
        a.getAlumnos().add(this);
    }

    public void deleteAsignatura (Asignatura a){
        this.asignaturas.remove(a);
        a.getAlumnos().remove(this);
    }

}
