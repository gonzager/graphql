package com.gi.graphql;

import com.gi.graphql.domain.Materia;
import com.gi.graphql.domain.Profesor;
import com.gi.graphql.repository.MateriaRepository;
import com.gi.graphql.repository.ProfesorRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProfesoresBootstrap implements InitializingBean{
    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    ProfesorRepository profesorRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bootstrapping data de ejemplo......");
        init();
    }

    @Transactional
    private void init() {
        Materia algoritmos = new Materia("Algoritmos y Estructura de Datos",1,"08-2021",5);
        Materia paradigmas = new Materia("Paradigmas de Programacion", 2, "08-2026",8);
        Materia disenio = new Materia( "Diseño de Sistemas", 3, "08-2028",   6);
        Materia sisop =  new Materia("Sistemas Operativos",2,"08-2027", 8);
        materiaRepository.save(algoritmos);
        materiaRepository.save(paradigmas);
        materiaRepository.save(disenio);
        materiaRepository.save(sisop);

        Profesor gerardo = new Profesor(0L,"Gerardo","Gonzalez", 2002, 55,  Stream.of(algoritmos, paradigmas).collect(Collectors.toSet()));
        Profesor javier = new Profesor(0L, "Javier", "Molina", 2018, 40,Stream.of(paradigmas, disenio).collect(Collectors.toSet()));
        Profesor nicolas= new Profesor(0L, "Nicolas", "Lopez", 2022,10, Stream.of(algoritmos).collect(Collectors.toSet()));
        profesorRepository.save(gerardo);
        profesorRepository.save(javier);
        profesorRepository.save(nicolas);
    }
}
