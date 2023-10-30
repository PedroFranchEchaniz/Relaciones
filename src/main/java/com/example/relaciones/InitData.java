package com.example.relaciones;

import com.example.relaciones.Clases.Alumno;
import com.example.relaciones.Clases.Asignatura;
import com.example.relaciones.Repositorio.AlumnoRepositorio;
import com.example.relaciones.Repositorio.AsignaturaRepositorio;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final AlumnoRepositorio alumnoRepositorio;
    private final AsignaturaRepositorio asignaturaRepositorio;

    @PostConstruct
    public void init(){
        Alumno a1 = Alumno.builder()
                .nombre("Pedro")
                .apellidos("Franch")
                .build();
        alumnoRepositorio.save(a1);

        Asignatura as1 = Asignatura.builder()
                .nombre("Mates")
                .horas(2)
                .descripcion("Mates faciles de sociales")
                .build();
        asignaturaRepositorio.save(as1);
    }


}
