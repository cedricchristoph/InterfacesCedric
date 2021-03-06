CREATE DATABASE escuelacocina;
use escuelacocina;

CREATE TABLE levels (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    levelName VARCHAR(30) NOT NULL
);

CREATE TABLE users (
    username VARCHAR(30) PRIMARY KEY,
    pass VARCHAR(50) NOT NULL,
    userLevel INTEGER,
    FOREIGN KEY (userLevel) REFERENCES levels(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE authorization (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    levelid INTEGER NOT NULL,
    authorized INTEGER NOT NULL,
    FOREIGN KEY (levelid) REFERENCES levels(id) ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE receta_tipos (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(30) NOT NULL,
    imagen VARCHAR(150) DEFAULT NULL
);

CREATE TABLE recetas (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50) NOT NULL,
    autor VARCHAR(30),
    tipo INTEGER,
    ingredientes VARCHAR(150),
    pasos VARCHAR (500),
    comensales INTEGER(3),
    tiempoPreparacion INTEGER(5),
    calorias FLOAT,
    imagen VARCHAR(200),
    FOREIGN KEY (autor) REFERENCES users(username) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (tipo) REFERENCES receta_tipos(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO levels (id, levelName) VALUES (1, "Alumno");
INSERT INTO levels (id, levelName) VALUES (2, "Profesor");

INSERT INTO authorization (id, levelid, authorized) VALUES (1, 2, 0);
INSERT INTO authorization (id, levelid, authorized) VALUES (2, 2, 1);
INSERT INTO authorization (id, levelid, authorized) VALUES (3, 2, 2);
INSERT INTO authorization (id, levelid, authorized) VALUES (4, 2, 3);
INSERT INTO authorization (id, levelid, authorized) VALUES (5, 2, 4);
INSERT INTO authorization (id, levelid, authorized) VALUES (6, 2, 5);
INSERT INTO authorization (id, levelid, authorized) VALUES (6, 2, 6);
INSERT INTO authorization (id, levelid, authorized) VALUES (7, 1, 0);
INSERT INTO authorization (id, levelid, authorized) VALUES (8, 1, 1);
INSERT INTO authorization (id, levelid, authorized) VALUES (9, 1, 2);
INSERT INTO authorization (id, levelid, authorized) VALUES (10, 1, 3);

INSERT INTO receta_tipos (id, tipo, imagen) VALUES (1, "Entrante", "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/salat.png");
INSERT INTO receta_tipos (id, tipo, imagen) VALUES (2, "Primero", "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/soup.png");
INSERT INTO receta_tipos (id, tipo, imagen) VALUES (3, "Segundo", "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/steak.png");
INSERT INTO receta_tipos (id, tipo, imagen) VALUES (4, "Postre", "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/dessert.png");

INSERT INTO users (username, pass, userLevel) VALUES ("profe", "profe", 2);
INSERT INTO users (username, pass, userLevel) VALUES ("admin", "admin", 2);
INSERT INTO users (username, pass, userLevel) VALUES ("juan", "j4", 1);
INSERT INTO users (username, pass, userLevel) VALUES ("pepe", "p4", 2);
INSERT INTO users (username, pass, userLevel) VALUES ("yaiza", "y5", 1);

INSERT INTO recetas (titulo, autor, tipo, ingredientes, pasos, comensales, tiempoPreparacion, calorias, imagen)
VALUES("Flan", "juan", 4, "-Huevos;-Leche", "-Batir;-Hornear", 4, 30, 140, "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/flan.jpg");

INSERT INTO recetas (titulo, autor, tipo, ingredientes, pasos, comensales, tiempoPreparacion, calorias, imagen)
VALUES("Pollo", "juan", 3, "-Pollo;-Aceite", "-Poner en la plancha", 2, 15, 200, "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/pollo.jpg");

INSERT INTO recetas (titulo, autor, tipo, ingredientes, pasos, comensales, tiempoPreparacion, calorias, imagen)
VALUES("Merluza", "admin", 3, "-Merluza de 500g; -Aceite; -Cebolla;- Tomate;- Agua;", "-Poner a rehogar la cebolla y el tomate con aceite 10 minutos;- A??adir el pescado y un vaso de agua", 2, 45, 300, "/home/cedric/Escritorio/GitHub/InterfacesCedric/GestionEstudiantes/src/es/iespuertodelacruz/cc/gestionestudiantes/res/merluza.jpg");

INSERT INTO recetas (titulo, autor, tipo, ingredientes, pasos, comensales, tiempoPreparacion, calorias, imagen)
VALUES("Guacamole", "juan", 1, "- Aguacate;- Cebolla;- Lim??n;- Tomate", "- Pelar y cortar todos los ingredientes;- Machacar el aguacate con un tenedor;- Mezclar todo bien", 4, 20, 140, NULL);

INSERT INTO recetas (titulo, autor, tipo, ingredientes, pasos, comensales, tiempoPreparacion, calorias, imagen)
VALUES("Bizcochon", "yaiza", 4, "- Harina;- Huevos;- Leche;- Aceite;- Levadura; Yogurt", "- Mezclar los ingredientes secos y reservar;- Mezclar los dem??s ingredientes;- A??adir a los liquidos la mezcla de los ingredientes secos poco a poco removiendo bien;- Engrasar el molde y poner la masa, dejar en el horno precalentado a 180 grados por 30 minutos", 4, 60, 400, NULL);

INSERT INTO recetas (titulo, autor, tipo, ingredientes, pasos, comensales, tiempoPreparacion, calorias, imagen)
VALUES("Sopa de Pollo", "admin", 2, "- Apio;- Agua;- Cebolla;- Nabo;- Chiribia;- Puerro;- Muslo de pollo", "-Poner ha herbir una olla grande con mucha agua;- Mientras limpiar, pelar y cortar bien los ingredientes y a??adirlos a la olla y dejar cociendo 1hora", 4, 75, 150, NULL);
