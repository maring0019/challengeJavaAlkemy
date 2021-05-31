/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Genero;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Personaje;
import com.example.demo.services.OperationServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mariela
 */
@Controller

public class GeneralController {
    @Autowired
    private OperationServices operationServices;
   
    /* 
    Lista todos los personajes existentes.
    */
 
    @GetMapping("/characters")
    public String listarTodosPersonajes(Model model) {
        try {
            
            List<Personaje> personajes= operationServices.getPersonajes();
            model.addAttribute("personajes", personajes);
            
            return "listarPersonajes";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "No se pudo listar los personajes.");
            
            return "error";
        }       
    }
    
     /* 
    Devuelve el detalle del personaje dado el id correspondiente.
    */
    
    @GetMapping("/characters/detalle/{id}")
    public String buscarPersonaje(@PathVariable int id, Model model) {
        try {
            
            Personaje personaje = operationServices.getPersonaje(id);

            model.addAttribute("personaje", personaje);

            return "personaje";
            
        } catch (Exception e) {

            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El personaje no existe.");
            
            return "error";
        }
    }
   
    /* 
    Lista el personaje que tiene el nombre dado como parametro.
    */
    @GetMapping("/characters/{nombre}")
    public String listarPersonajes(@PathVariable String nombre, Model model) {
        try {

            
            List<Personaje> personajes= operationServices.getBuscarPersonaje(nombre);
      
    
            model.addAttribute("personajes", personajes);
            model.addAttribute("nombre", nombre);

            return "listarPersonajesNombre";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "No existen personajes con ese nombre.");
            
            return "error";
        }       
    }
    
    /* 
      Lista los personaje que tiene la edad dada como parametro.
    */
    @GetMapping("/characters/busquedaedad/{edad}")
    public String listarPersonajes(@PathVariable int edad, Model model) {
        try {

            
            List<Personaje> personajes= operationServices.getBuscarPersonaje(edad);

    
            model.addAttribute("personajes", personajes);
             model.addAttribute("edad", edad);

            return "listarPersonajesEdad";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El personaje no existe.");
            
            return "error";
        }       
    }
    
   /* 
     Elimina el personaje dado el id como parametro.
    */
    @GetMapping("/characters/eliminar")
    public String eliminarPersonaje(@RequestParam(name = "id") int id, Model model) {
         try {
            
            model.addAttribute("mensaje", operationServices.eliminarPersonaje(id));
            
            return "eliminarPersonaje";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El personaje no existe.");
            
            return "error";
        }       
    }
   
    /* 
     Modifica el nombre del personaje dado el id como parametro.
    */
    @GetMapping("/characters/modificar")
    public String modificarPersonaje(@RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre, 
                                Model model) {
        try {
            
            model.addAttribute("mensaje", operationServices.modificarPersonaje(nombre, id));
            model.addAttribute("personaje", operationServices.getPersonaje(id));
            
            return "modificarPersonaje";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "El personaje no existe.");
            
            return "error";
        }       
    }
    
    /* 
     Lista todas las peliculas existentes.
    */
 
    @GetMapping("/movies")
    public String listarPeliculas(Model model) {
        try {
            
            List<Pelicula> peliculas= operationServices.getPeliculas();
            model.addAttribute("peliculas", peliculas);
            
            return "listarPeliculas";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "No se pudo listar los peliculas.");
            
            return "error";
        }       
    }
    
    /* 
    Devuelve el detalle de la pelicula dado el id correspondiente.
    */
    
    @GetMapping("/movies/detalle/{id}")
    public String buscarPelicula(@PathVariable int id, Model model) {
        try {
            
           Pelicula pelicula = operationServices.getPelicula(id);

            model.addAttribute("pelicula", pelicula);

            return "pelicula";
            
        } catch (Exception e) {

            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "La pelicula no existe.");
            
            return "error";
        }
    }
    
  
    /* 
    Lista la pelicula que coincide con el nombre dado.
    */
    @GetMapping("/movies/listar")
    public String listarPeliculas(@RequestParam(name = "nombre") String nombre, Model model) {
        try {

            
            List<Pelicula> peliculas= operationServices.getBuscarPeliculas(nombre);

    
            model.addAttribute("peliculas", peliculas);
            model.addAttribute("nombre", nombre);

            return "listarPeliculasNombre";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "La pelicula no existe.");
            
            return "error";
        }       
    }
    
     /* 
    Lista las peliculas que coincide con el id del genero dado como parámetro.
    */
    @GetMapping("/movies/listarGenero")
    public String listarPeliculasGenero(@RequestParam(name = "genre") int idGenero, Model model) {
        try {

            Genero genero = operationServices.getGenero(idGenero);
            System.out.println(genero.getId());
            List<Pelicula> peliculas= genero.getPeliculas();
           System.out.println(peliculas);
            model.addAttribute("peliculas", peliculas);
            model.addAttribute("nombre", genero.getNombre());

            return "listarPeliculasGenero";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "La pelicula no existe.");
            
            return "error";
        }       
    }
    
    
    /* 
     Elimina la pelicula que coinicde con  el id dado como parametro.
    */
    @GetMapping("/movies/eliminar")
    public String eliminarPelicula(@RequestParam(name = "id") int id, Model model) {
         try {
            
            model.addAttribute("mensaje", operationServices.eliminarPelicula(id));
            
            return "eliminarPelicula";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "La pelicula no existe.");
            
            return "error";
        }       
    }
     /* 
     Modifica el nombre de la pelicula dado el id como parametro.
    */
    @GetMapping("/movies/modificar")
    public String modificarPelicula(@RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre, 
                                Model model) {
        try {
            
            model.addAttribute("mensaje", operationServices.modificarPelicula(nombre, id));
            model.addAttribute("pelicula", operationServices.getPelicula(id));
            
            return "modificarPelicula";
            
        } catch (Exception e) {
            
            System.out.println("Mensaje: " + e.getMessage());
            model.addAttribute("mensaje", "La pelicula no existe.");
            
            return "error";
        }       
    }
    
    
    
}
