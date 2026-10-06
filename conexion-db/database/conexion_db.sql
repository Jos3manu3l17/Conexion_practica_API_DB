create database conexion_db;
use conexion_db;

create table usuarios (
idUsuario int auto_increment primary key,
nombre varchar(100),
correo varchar(100)
);

INSERT INTO usuarios (nombre, correo)
VALUES
('Juan Pérez', 'juan@gmail.com'),
('María López', 'maria@gmail.com'),
('Jose Manuel', 'jose@gmail.com');

select * from usuarios;
describe usuarios;