package com.gi.graphql.service;

import com.gi.graphql.domain.Materia;
import com.gi.graphql.domain.Profesor;
import com.gi.graphql.repository.MateriaRepository;
import com.gi.graphql.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

//todo cambiar las excepciones
@Service
public class ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    MateriaRepository materiaRepository;

    @Transactional(readOnly=true)
    public List<Profesor> getProfesoresByNombre(String nombreFilter) {
        return profesorRepository.findAllByNombreOrApellido(nombreFilter);
    }

    @Transactional(readOnly=true)
    public Profesor getProfesor(Long id) {
        return profesorRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
    }

    @Transactional()
    public Profesor actualizarProfesor(Long idProfesor, Profesor profesorActualizado) {
        return profesorRepository.findById(idProfesor).map( it -> {
            it.setNombre(profesorActualizado.getNombre());
            it.setApellido(profesorActualizado.getApellido());
            profesorRepository.save(it);
            return it;
        }).orElseThrow( () -> new RuntimeException(""));
    }

    @Transactional()
    public Profesor agregarMateria(Long idProfesor, Materia materia) {
        Profesor profesor = profesorRepository.findById(idProfesor).orElseThrow(
                ()-> new RuntimeException("")
        );
        Optional<Materia> materiaNueva =  materia.getNombre().isEmpty()
                ? materiaRepository.findById(materia.getId())
                : materiaRepository.findByNombre(materia.getNombre());
        if(materiaNueva.isPresent()) {
            profesor.agregarMateria(materiaNueva.get());
            profesorRepository.save(profesor);
        }
        return profesor;
    }

    @Transactional
    public Profesor agregarProfesor( Profesor profesor) {
        return profesorRepository.save(profesor);
    }
}
