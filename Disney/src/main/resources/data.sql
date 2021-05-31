
INSERT INTO Genero (id,nombre,imagen) VALUES
    (1, 'Acción','accion.png'),
    (2, 'Comedia','comedia.jpg'),
    (3, 'Romance','romance.jpg'),
    (4, 'Aventura','aventura.jpg');

INSERT INTO Pelicula (id,imagen, titulo, fecha_creacion, calificacion, genero_id) VALUES
    (1, 'theRock.jpg','The Rock','12/05/1996',2, 1),
    (2, 'elSolMedianoche.jpg','El sol de medianoche','25/08/2019',3,3),
    (3, 'cieloOscuro.jpg','El cielo oscuro','02/08/2019',1,3);

INSERT INTO Personaje (id,imagen,nombre,edad, peso,historia, pelicula_id) VALUES
    (1, 'sol.jpg', 'Sol',23,1.4,'Inicio con mi carrera en ...',1),
    (2, 'luna.jpg', 'Luna',45,2.4,'Inicio con mi carrera en ...',1),
    (3, 'cielo.jpg', 'Cielo',80,3.4,'Inicio con mi carrera en ...',2);
   


INSERT INTO peliculas_personajes(pelicula_id, personaje_id) VALUES
    (1,1),
    (1,2),
    (2,1),
    (2,1);