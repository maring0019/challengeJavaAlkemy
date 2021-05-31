/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.model.Genero;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Personaje;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.PersonajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author  mariela
 */
@Service
public class OperationServices {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;
    
     @Autowired
    private GeneroRepository generoRepository;
     
     
    /* 
    Devuelve la lista de todos los personajes.
    */
    public List<Personaje> getPersonajes(){
    
        return personajeRepository.findAll();
    
    }
    /* 
    Devuelve el personaje buscado con el id recibido.
    */
    public Personaje getPersonaje(int id){

        Optional<Personaje> personaje= personajeRepository.findById(id);
    
        return personaje.get();   
    
    }

    /* 
    Devuelve los personajes que coinciden con el nombre recibido.
    */
    public List<Personaje> getBuscarPersonaje(String name){
  
        List<Personaje> personaje = personajeRepository.findByNombre(name);
        return personaje;     
    }
    
    /* 
    Devuelve los personajes que coinciden con la edad recibida.
    */
    public List<Personaje> getBuscarPersonaje(int edad){ 
  
        List<Personaje> personaje = personajeRepository.findByEdad(edad);
        return personaje;     
    }
    
     /* 
    Elimina el personaje que conincide con el id recibido.
    */
    
    public String eliminarPersonaje(int id) {
        try {

            Optional<Personaje> personaje = personajeRepository.findById(id);
            personajeRepository.delete(personaje.get());

            return "Exito";
            
        } catch (Exception e) {
            
            return "Error"; 
        
        }
    }
    
    /* 
    Modifica el nombre del personaje que coincide con el id recibido.
    */
    
    public String modificarPersonaje(String nombre, int id) {
        try {

            Optional<Personaje> personaje = personajeRepository.findById(id);
            personaje.get().setNombre(nombre);
            personajeRepository.save(personaje.get());

            return "Exito";
            
        } catch (Exception e) {
        
            return "Error";
        
        }
    }
    
    
    
    
    /* 
    Devuelve la lista de todos las peliculas.
    */
    public List<Pelicula> getPeliculas(){
    
        return peliculaRepository.findAll();
    
    }
    
    /* 
    Devuelve la pelicula que coincide con el id recibido.
    */
    public Pelicula getPelicula(int id){

        Optional<Pelicula> pelicula= peliculaRepository.findById(id);
    
        return pelicula.get();   
    
    }
    
   /* 
     Devuelve las peliculas que coinciden con el nombre recibido.
    */
    public List<Pelicula> getBuscarPeliculas(String titulo){ 

        List<Pelicula> pelicula = peliculaRepository.findByTitulo(titulo);
        return pelicula;     
    }
    
    /* 
     Devuelve el genero que coinciden con el id de genero recibido.
    */
    public Genero getGenero(int idGenero){
     
      Optional<Genero> genero = generoRepository.findById(idGenero);
      
      return genero.get();     
    }
    
    /*
    public List<Pelicula> getBuscarPelicula(String orden){ Que devuelva listado dado orden="ASC o DESC"
    filtrar por edad, peso o películas/series
        if(orden.equals("ASC")) {/*Pasar a una lista ordenada. sort, map, etc...
            List<Pelicula> pelicula=getPeliculas().sort(c);
        }else{
            List<Pelicula> pelicula=getPeliculas().sort(c);
        }
         
        return pelicula;     
    }
     */
    
        
    /* 
    Elimina la pelicula, dado el id recibido.
    */
    
    public String eliminarPelicula(int id) {
        try {

            Optional<Pelicula> pelicula = peliculaRepository.findById(id);
            peliculaRepository.delete(pelicula.get());

            return "Exito";
            
        } catch (Exception e) {
            
            return "Error";
        
        }
    }
    
    /* 
    Modifica el titulo de la pelicula, dado el id recibido.
    */
    
    public String modificarPelicula(String titulo, int id) {
        try {

            Optional<Pelicula> pelicula = peliculaRepository.findById(id);
            pelicula.get().setTitulo(titulo);
            peliculaRepository.save(pelicula.get());

            return "Exito";
            
        } catch (Exception e) {
        
            return "Error";
        
        }
    }
    
    
    
}
