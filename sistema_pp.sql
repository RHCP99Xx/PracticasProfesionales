create database SistemaPP;

use SistemaPP;

create table usuario(
	idUsuario integer not null auto_increment, 
	nombres varchar(50) not null,
	apellidos varchar(50) not null,
	correo varchar(80) not null,
	contrasenia varchar(255) not null,
	tipo varchar(50) not null,
	PRIMARY KEY (idUsuario)
);

INSERT INTO Usuario VALUES(NULL, "Adair Benjamin", "Hernandez Ortiz", "adairho16@gmail.com", "123", "estudiante");
INSERT INTO Usuario VALUES(NULL, "Edgar", "Hernandez Viveros", "edgar@gmail.com", "123", "estudiante");
INSERT INTO Usuario VALUES(NULL, "Nina Victoria", "Morato Morales", "nina@gmail.com", "123", "estudiante");
INSERT INTO Usuario VALUES(NULL, "Leslie", "Loaiza Messeguer", "leslie6@gmail.com", "123", "estudiante");

create table estudiante(
	matricula varchar(10) not null,
	idUsuario integer not null,
	telefono varchar(14),
	PRIMARY KEY (matricula)
);

INSERT INTO Estudiante VALUES("S18012122", 1, "8168578");
INSERT INTO Estudiante VALUES("S18057893", 2, "8168890");
INSERT INTO Estudiante VALUES("S18098236", 3, "8166579");
INSERT INTO Estudiante VALUES("S18043357", 4, "8178453");


create table organizacion_vinculada(
	idOV integer not null auto_increment,
	nombre varchar(30),
	direccion varchar(100),
	telefono varchar(15),
	PRIMARY KEY (idOV)
);

INSERT INTO Organizacion_vinculada VALUES(NULL, "Organizacion Vinculada 1", "Direccion OV 1", "11111111");
INSERT INTO Organizacion_vinculada VALUES(NULL, "Organizacion Vinculada 2", "Direccion OV 2", "22222222");
INSERT INTO Organizacion_vinculada VALUES(NULL, "Organizacion Vinculada 3", "Direccion OV 3", "33333333");

create table proyecto(
	idProyecto integer not null auto_increment,
	nombre varchar(50),
	descripcion text,
	status varchar(50),
	fecha date,
	horario text,
	metodologia text,
	actividades text,
	objetivoGeneral text,
	objetivosInmediatos text,
	objetivosMediatos text,
	numeroEstudiantesSolicitados integer,
	numeroEstudiantesAsignados integer,
	idOV integer NOT NULL,
	PRIMARY KEY (idProyecto)
);

INSERT INTO Proyecto VALUES(NULL, "Proyecto 1", "Descripcion proyecto 1", "Activo", CURDATE(), "Lunes a viernes de 7am a 2pm", "Metodologia proyecto 1", "actividades proyecto 1", "Objetivo general proy. 1", "Objetivos inmediatos proy. 1", "Objetivos mediatos proy. 1", 2, 0, 1);
INSERT INTO Proyecto VALUES(NULL, "Proyecto 2", "Descripcion proyecto 2", "Activo", CURDATE(), "Lunes a viernes de 10am a 5pm", "Metodologia proyecto 2", "actividades proyecto 2", "Objetivo general proy. 2", "Objetivos inmediatos proy. 2", "Objetivos mediatos proy. 2", 1, 0, 2);
INSERT INTO Proyecto VALUES(NULL, "Proyecto 3", "Descripcion proyecto 3", "Activo", CURDATE(), "Lunes a viernes de 8am a 3pm", "Metodologia proyecto 3", "actividades proyecto 3", "Objetivo general proy. 3", "Objetivos inmediatos proy. 3", "Objetivos mediatos proy. 3", 1, 0, 3);



create table participacion(
	idParticipacion INT NOT NULL AUTO_INCREMENT,
	matricula varchar(10) not null,
	idProyecto integer not null,
	fechaInicio date,
	fechaFinal date,
	periodo varchar(35),
	PRIMARY KEY (idParticipacion)
);

INSERT INTO participacion VALUES(NULL, "S18012122", 1, CURDATE(), CURDATE(), 1);
INSERT INTO participacion VALUES(NULL, "S18057893", 2, CURDATE(), CURDATE(), 2);
INSERT INTO participacion VALUES(NULL, "S18043357", 3, CURDATE(), CURDATE(), 1);

create table expediente(
	idExpediente INT NOT NULL AUTO_INCREMENT,
	calificacionFinal float,
	comentarios text,
	totalHorasRealizadas integer,
	idParticipacion INT NOT NULL,
	PRIMARY KEY (idExpediente)
);

INSERT INTO Expediente VALUES(NULL, 10, "FIERRO PARIENTE", 480, 1);
INSERT INTO Expediente VALUES(NULL, 10, "FIERRO PARIENTE 2", 480, 3);
INSERT INTO Expediente VALUES(NULL, NULL, "FIERRO PARIENTE 3", 320, 2);

create table documento(
	idDocumento integer auto_increment not null,
	nombre varchar(60),
	peso float,
	ruta varchar(500),
	fechaSubida datetime,
	idExpediente INT NOT NULL,	
	PRIMARY KEY (idDocumento)
);

INSERT INTO Documento VALUES(NULL, "Documento 1", 12.0, "path/path", CURDATE(), 1);
INSERT INTO Documento VALUES(NULL, "Documento 2", 15.0, "path/path", CURDATE(), 1);
INSERT INTO Documento VALUES(NULL, "Documento 3", 8.0, "path/path", CURDATE(), 2);
INSERT INTO Documento VALUES(NULL, "Documento 4", 8.0, "path/path", CURDATE(), 3);

create table reporte(
	idDocumento integer not null,
	status varchar(50),
	fechaInicio date,
	fechaFin date,
	horasCubiertas integer,
	PRIMARY KEY (idDocumento)
);


INSERT INTO Reporte VALUES(1, "Aceptado", CURDATE(), CURDATE(), 50);
INSERT INTO Reporte VALUES(2, "Aceptado", CURDATE(), CURDATE(), 130);
INSERT INTO Reporte VALUES(3, "Aceptado", CURDATE(), CURDATE(), 180);
INSERT INTO Reporte VALUES(4, "Aceptado", CURDATE(), CURDATE(), 90);



create table eleccion(
	idEleccion INT NOT NULL AUTO_INCREMENT,
	matricula varchar(10) not null,
	idProyecto integer not null,
	periodo varchar(35),
	fecha date,
	nivelEleccion integer,
	PRIMARY KEY (idEleccion)
);


INSERT INTO eleccion VALUES(NULL, "S18012122", 1, 1, CURDATE(), 1);
INSERT INTO eleccion VALUES(NULL, "S18012122", 2, 1, CURDATE(), 2);
INSERT INTO eleccion VALUES(NULL, "S18012122", 3, 1, CURDATE(), 3);




alter table estudiante add constraint
fk_estudiante_1 FOREIGN KEY (idUsuario)
REFERENCES usuario (idUsuario);

alter table participacion add constraint
fk_participa_estudiante_proyecto_1 FOREIGN KEY (matricula)
REFERENCES estudiante (matricula);

alter table participacion add constraint
fk_participa_estudiante_proyecto_2 FOREIGN KEY (idProyecto)
REFERENCES proyecto (idProyecto);

alter table eleccion add constraint
fk_eleccion_estudiante_proyecto_1 FOREIGN KEY (matricula)
REFERENCES estudiante (matricula);

alter table eleccion add constraint
fk_eleccion_estudiante_proyecto_2 FOREIGN KEY (idProyecto)
REFERENCES proyecto (idProyecto);

alter table proyecto add constraint
fk_proyecto_1 FOREIGN KEY (idOV)
REFERENCES organizacion_vinculada (idOV);

alter table documento add constraint
fk_documento_1 FOREIGN KEY (idExpediente)
REFERENCES expediente (idExpediente);


SELECT Documento.nombre, Documento.fechaSubida
	FROM Usuario INNER JOIN Estudiante ON Usuario.idUsuario = Estudiante.idUsuario
		INNER JOIN Participacion ON Estudiante.matricula = Participacion.matricula
			INNER JOIN Expediente ON Participacion.idParticipacion = Expediente.idParticipacion
				INNER JOIN Documento ON Expediente.idExpediente = Documento.idExpediente
					INNER JOIN Reporte ON Documento.idDocumento = Reporte.idDocumento WHERE Usuario.idUsuario = 1 ;