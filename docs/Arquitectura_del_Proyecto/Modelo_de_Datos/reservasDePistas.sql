CREATE DATABASE reservas_de_pistas;

USE reservas_de_pistas;

CREATE TABLE `usuarios` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nif` varchar(9) NOT NULL ,
  `nombre` varchar(255) NOT NULL,
  `apellido1` varchar(255) NOT NULL,
  `apellido2` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL ,
  `username` varchar(255) NOT NULL ,
  `password` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `sexo` enum('Hombre','Mujer') NOT NULL,
  `role` varchar(255) NOT NULL default 'ROLE_USER',
  `fecha_nacimiento` date NOT NULL,
  `fecha_registro` date NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8mb4;

CREATE TABLE `pistas` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL UNIQUE,
  `deporte` varchar(255) NOT NULL,
  `apertura` time NOT NULL,
  `cierre` time NOT NULL,
  `duracion` time NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 10 DEFAULT CHARSET = utf8mb4;

CREATE TABLE `reserva` (
  `id_usuario` int(10) unsigned NOT NULL,
  `id_pista` int(10) unsigned NOT NULL,
  `fecha` date NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  PRIMARY KEY (`id_usuario`,
`id_pista`),
  KEY `id_pista` (`id_pista`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_pista`) REFERENCES `pistas` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;

