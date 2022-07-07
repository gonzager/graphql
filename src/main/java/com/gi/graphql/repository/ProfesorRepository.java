package com.gi.graphql.repository;

import com.gi.graphql.domain.Profesor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    @EntityGraph(attributePaths = {"materias"})
    Optional<Profesor> findById(Long Id);

    @EntityGraph(attributePaths = {"materias"})
    @Query("select p from Profesor as p where p.nombre like :nombreFilter or p.apellido like :nombreFilter")
    List<Profesor> findAllByNombreOrApellido(@Param("nombreFilter") String nombreFilter);
}
