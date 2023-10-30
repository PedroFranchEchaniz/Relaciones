package com.example.relaciones.Clases;

import jakarta.persistence.Embeddable;
import jakarta.persistence.MapsId;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalificacionPK  implements Serializable {

    private static final long serialVersionUID = 1L;

    private long alumno_id;
    private long asginatura_id;
    private long instrumento_id;
    private long referente_id;

}
