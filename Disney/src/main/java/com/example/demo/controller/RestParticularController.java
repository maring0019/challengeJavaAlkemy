package com.example.demo.controller;

import com.example.demo.model.InitElement;
import com.example.demo.services.RestOperationServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestParticularController {

    @Autowired
    private RestOperationServices restOperationServices;
 
    
    /* 
    Servicio Post para crear un nuevo personaje.
    */
   
    @PostMapping("/nuevoPersonaje")
    public String nuevoPersonaje(@RequestBody InitElement initElement) {
        
        String mensaje = restOperationServices.nuevoPersonaje(initElement.getPersonajeImagen(), initElement.getPersonajeNombre(), initElement.getPersonajeEdad(), initElement.getPersonajePeso(), initElement.getPersonajeHistoria()); 

        return mensaje;
    }

    /*    
    Servicio Post para crear una nueva pelicula.
    */
    
    @PostMapping("/nuevaPelicula")
    public String nuevaPelicula(@RequestBody InitElement initElement) {
        
        String mensaje = restOperationServices.nuevaPelicula(initElement.getPeliculaImagen(), initElement.getPeliculaTitulo(), initElement.getPeliculafechaCreacion(), initElement.getPeliculaCalificacion(), initElement.getGeneroId());
    
        return mensaje;
    }
    

}
