package com.gi.graphql.repository;

import com.gi.graphql.domain.Materia;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MateriaRepository extends CrudRepository<Materia, Long> {
    Optional<Materia> findByNombre(String nombre);
}
