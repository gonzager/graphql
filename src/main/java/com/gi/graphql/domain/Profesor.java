package com.gi.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id = 0L;

    String nombre = "";
    String apellido = "";
    Integer anioComienzo = 0;
    Integer puntajeDocente = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    Set<Materia> materias = new HashSet<Materia>();

    public void agregarMateria(Materia materia) {
        materias.add(materia);
    }
}
