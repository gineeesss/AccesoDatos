-- Crear la base de datos y usarla
CREATE DATABASE bdclientes;
USE bdclientes;

-- Crear el usuario sin contraseña / ya exuste seguramente
CREATE USER 'usrcliente'@'localhost';

-- Otorgar permisos al usuario sobre la base de datos
GRANT ALL PRIVILEGES ON bdclientes.* TO 'usrcliente'@'localhost';
FLUSH PRIVILEGES;

-- Crear la tabla cliente
CREATE TABLE cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    tfn VARCHAR(15),
    dir VARCHAR(255),
    tipocliente VARCHAR(50) DEFAULT NULL,
    zona ENUM('CA', 'BA') NOT NULL
);
