package com.gi.graphql.graphql;

import com.gi.graphql.domain.Profesor;
import com.gi.graphql.repository.ProfesorRepository;
import com.gi.graphql.service.ProfesorService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEnableDataFetcherInstrumentation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class ProfesoresDataFetcher {

    @Autowired
    ProfesorService profesorService;

    @DgsQuery
    List<Profesor> profesores(@InputArgument Optional<String> nombreFilter  ) {
        return profesorService.getProfesoresByNombre(nombreFilter.isPresent() ? nombreFilter.get().concat("%") : "%") ;
    }

    @DgsQuery
    @DgsEnableDataFetcherInstrumentation(false)
    Profesor profesor(@InputArgument Integer idProfesor ) {
        return profesorService.getProfesor(idProfesor.longValue());
    }
}
