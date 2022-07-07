package com.gi.graphql.graphql;

import com.gi.graphql.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateProfesor {
    Integer id;
    String nombre;
    String apellido;

    public Profesor toProfesor() {
        Profesor profesor = new Profesor();
        profesor.setNombre(this.nombre);
        profesor.setApellido(this.apellido);
        return profesor;
    }
}
