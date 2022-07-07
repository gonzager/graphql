package com.gi.graphql.graphql;

import com.gi.graphql.domain.Profesor;
import com.gi.graphql.service.ProfesorService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class ProfesoresMutation {

    @Autowired
    ProfesorService profesorService;


    @DgsData(parentType = "Mutation")
    Profesor actualizarProfesor(@NotNull UpdateProfesor updateProfesor){
        return profesorService.actualizarProfesor(updateProfesor.getId().longValue(), updateProfesor.toProfesor());
    }

    @DgsData(parentType = "Mutation")
    Profesor agregarMateria(@NotNull Long idProfesor, @NotNull MateriaInput materiaInput){
        return profesorService.agregarMateria(idProfesor,materiaInput.toMateria());
    }

    @DgsData(parentType = "Mutation")
    Profesor agregarProfesor(@NotNull ProfesorInput profesorInput ) {
        return profesorService.agregarProfesor(profesorInput.toProfesor());
    }
}

