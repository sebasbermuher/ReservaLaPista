CREATE DATABASE reservas_de_pistas;

USE reservas_de_pistas;

-- reservas_de_pistas.pistas definition

CREATE TABLE `pistas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apertura` varchar(255) NOT NULL,
  `cierre` varchar(255) NOT NULL,
  `deporte` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1730s9pd0bl6nw5e6v45546np` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

-- reservas_de_pistas.usuarios definition

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido1` varchar(255) NOT NULL,
  `apellido2` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `fecha_nacimiento` varchar(255) NOT NULL,
  `fecha_registro` varchar(255) NOT NULL,
  `localidad` varchar(255) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`),
  UNIQUE KEY `UK_igfhcb3km5lfdcc9v0v3mdbbg` (`nif`),
  UNIQUE KEY `UK_m2dvbwfge291euvmk6vkkocao` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;


-- reservas_de_pistas.reserva definition

CREATE TABLE `reserva` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora_inicio` varchar(255) DEFAULT NULL,
  `id_pista` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKhkfs93i70x726y4ihs7iu7pyn` (`fecha`,`hora_inicio`),
  KEY `FK1ifa470ho0dqxxsffku0ka0c2` (`id_pista`),
  KEY `FKj8cxeodpmehovje6152y4ywqm` (`id_usuario`),
  CONSTRAINT `FK1ifa470ho0dqxxsffku0ka0c2` FOREIGN KEY (`id_pista`) REFERENCES `pistas` (`id`),
  CONSTRAINT `FKj8cxeodpmehovje6152y4ywqm` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1;