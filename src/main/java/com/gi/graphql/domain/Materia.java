package com.gi.graphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nombre ="";
    Integer anio = 1;
    String codigo = "";
    Integer cargaHoraSemanal = 0;


    public Materia( String nombre, Integer anio, String codigo, Integer cargaHoraSemanal){
        this.nombre = nombre;
        this.anio = anio;
        this.codigo = codigo;
        this.cargaHoraSemanal = cargaHoraSemanal;
    }

}
