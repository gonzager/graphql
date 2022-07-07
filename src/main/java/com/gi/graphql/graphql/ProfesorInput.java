package com.gi.graphql.graphql;

import com.gi.graphql.domain.Materia;
import com.gi.graphql.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;

@Data
@NoArgsConstructor
public class ProfesorInput {
    String nombre = "";
    String apellido = "";
    Integer anioComienzo = 0;
    Integer puntajeDocente = 0;


    public Profesor toProfesor() {
        return new Profesor(0L, this.nombre, this.apellido, this.anioComienzo, this.puntajeDocente, new HashSet<Materia>());
    }
}