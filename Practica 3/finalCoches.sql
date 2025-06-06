drop database if exists finalCoches;
create database finalCoches;
use finalCoches;
create table opcionesModelo(
	modelo VARCHAR(30) PRIMARY KEY
);
create table opcionesMotor(
    motor VARCHAR(30) PRIMARY KEY
 );
create table opcionesColor(
    color VARCHAR(30) PRIMARY KEY
);
create table opcionesRuedas(
    ruedas integer PRIMARY KEY
);
create table opcionesPilotoAutomatico(
    pilotoAutomatico boolean PRIMARY KEY
);
insert into opcionesModelo values ("Model S"), ("Model X"), ("Model Y"), ("Model 3");
insert into opcionesMotor values ("Dual"), ("Trasera"), ("Triple");
insert into opcionesColor values ("Blanco"), ("Negro"), ("Gris"), ("Azul"), ("Rojo");
insert into opcionesRuedas values (19), (20), (21);
insert into opcionesPilotoAutomatico values (true), (false);

create table pedidos(
	id integer auto_increment PRIMARY KEY,
	modelo VARCHAR(30),
    motor VARCHAR(30),
    color VARCHAR(30),
    ruedas integer,
    pilotoAutomatico boolean
);

