package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class InitElement {

    @JsonProperty("personaje.imagen")
    private String personajeImagen;
    
    @JsonProperty("personaje.nombre")
    private String personajeNombre;
    
    @JsonProperty("personaje.edad")
    private int personajeEdad;
    
    @JsonProperty("personaje.peso")
    private float personajePeso;
    
    @JsonProperty("personaje.historia")
    private String personajeHistoria;
    
    @JsonProperty("pelicula.imagen")
    private String peliculaImagen;

    @JsonProperty("pelicula.titulo")
    private String peliculaTitulo;
    
    @JsonProperty("pelicula.fechaCreacion")
    private String peliculafechaCreacion;
    
    @JsonProperty("pelicula.calificacion")
    private int peliculaCalificacion;
    
    @JsonProperty("genero.id")
    private int generoId;

  
  
}
