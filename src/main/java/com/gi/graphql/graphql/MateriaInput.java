package com.gi.graphql.graphql;

import com.gi.graphql.domain.Materia;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaInput {
    Integer id;
    String nombre;

    Materia toMateria() {
        Materia materia = new Materia();
        materia.setId(this.id.longValue());
        materia.setNombre(this.nombre);
        return materia;
    }
}
