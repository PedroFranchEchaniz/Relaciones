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

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @ManyToMany
    @JoinTable(name = "Matricula",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "asignaturas_id"))
    private List<Asignatura> asignaturas = new ArrayList<>();

    public void addAsignatura(Asignatura asignatura){
        this.asignaturas.add(asignatura);
        asignatura.getAlumnos().add(this);
    }

    public void deleteAsignatura (Asignatura a){
        this.asignaturas.remove(a);
        a.getAlumnos().remove(this);
    }

    @OneToMany(mappedBy = "alumno")
    private List<Calificacion> calificaciones = new ArrayList<>();

}
