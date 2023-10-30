package com.example.relaciones.Repositorio;

import com.example.relaciones.Clases.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepositorio extends JpaRepository<Alumno, Long> {
}
