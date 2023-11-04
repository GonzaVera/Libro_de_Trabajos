# Libro_de_Trabajos BD usada

CREATE DATABASE loneriasimple;
USE loneriasimple;

create table cliente(
IDcliente int not null auto_increment primary key,
nombre varchar(100) not null,
apellido varchar(100) not null,
telefono varchar(100) not null,
direccion varchar(100) not null,
descripcion  varchar(100) not null,
DNI varchar(8) not null
);
