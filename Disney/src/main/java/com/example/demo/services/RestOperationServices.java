package com.example.demo.services;

import com.example.demo.model.Genero;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pelicula;
import com.example.demo.model.Personaje;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.PersonajeRepository;


@Service
public class RestOperationServices {
    
    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private GeneroRepository generoRepository;
    
    /* 
    Crea una nueva pelicula.
    */
   
    public String nuevaPelicula(String imagen, String titulo, String fechaCreacion,int calificacion, int genero_id ){
        try {

            Optional<Genero> genero= generoRepository.findById(genero_id);
            Pelicula pelicula = new Pelicula(imagen, titulo, fechaCreacion,calificacion,genero.get());
            peliculaRepository.save(pelicula);

            return "Exito, pelicula creada. -> id: " + pelicula.getId() +
                    " nombre: " + pelicula.getTitulo();
            
        } catch (Exception e) {
        
            System.out.println("Mensaje: " + e.getMessage());
            
            return "Error - La pelicula no pudo ser creada.";
        }     
    }
    
    /* 
    Crea un nuevo personaje.
    */
    
    public String nuevoPersonaje(String imagen, String nombre, int edad, float peso, String historia){
        try {

            
            Personaje personaje = new Personaje(imagen, nombre, edad, peso, historia);
            personajeRepository.save(personaje);
            
            return "Exito, personaje creado -> id: " +personaje.getId();
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            
            return "Error - El personaje no pudo ser creado.";
        
        }
    }

   
    
    
}
