CREATE TABLE concesionario (
	id int AUTO_INCREMENT primary key,
    nombreConcesionario varchar(50) not null,
    dir varchar(50) not null, 
 	telefono int not null,
    poblacion varchar(50) not null
);