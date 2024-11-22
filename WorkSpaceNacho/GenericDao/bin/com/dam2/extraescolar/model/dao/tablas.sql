CREATE TABLE participantes (
id INTEGER PRIMARY KEY AUTO_INCREMENT, 
nif VARCHAR(12) UNIQUE, 
nombre VARCHAR(20), 
apellidos VARCHAR(45), 
fecha_nacimiento DATE, 
id_grupo INTEGER);

CREATE TABLE grupos (id INTEGER PRIMARY KEY AUTO_INCREMENT, cod_grupo VARCHAR(10) NOT NULL UNIQUE, descripcion VARCHAR(50))

ALTER TABLE participantes ADD FOREIGN KEY (id_grupo) REFERENCES grupos(id);