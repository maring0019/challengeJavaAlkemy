/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.Pelicula;
import com.example.demo.model.Personaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author  mariela
 */
@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer>{
    public List<Personaje> findByNombre(String nombre);
    public List<Personaje> findByEdad(int edad);
}

