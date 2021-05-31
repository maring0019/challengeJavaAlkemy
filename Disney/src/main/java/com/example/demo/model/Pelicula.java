/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author  mariela
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String imagen;
    private String titulo;
    private String fecha_creacion;
    private int calificacion;
       
    @ManyToMany
    @JoinTable(name = "peliculas_personajes",
        joinColumns = @JoinColumn(name = "pelicula_id"),
        inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private List<Personaje> personajes;
    
    @ManyToOne(targetEntity = Genero.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    public Pelicula(String imagen, String titulo, String fecha_creacion, int calificacion, Genero genero) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fecha_creacion = fecha_creacion;
        this.calificacion = calificacion;
        this.genero = genero;
    }

  

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
