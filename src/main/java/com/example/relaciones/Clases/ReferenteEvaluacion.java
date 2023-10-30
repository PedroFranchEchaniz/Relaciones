package com.example.relaciones.Clases;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReferenteEvaluacion {

    @Id @GeneratedValue
    private Long id;

    private String descripcion;

    @ManyToOne
    private Asignatura asignatura;

    public void addToAsignatura (Asignatura a){
        this.asignatura = a;
        a.getReferentes().add(this);
    }

    public void deleteAsignatura (Asignatura a){
        this.asignatura = null;
        a.getReferentes().remove(this);
    }
}
