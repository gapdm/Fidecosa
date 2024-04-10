Drop Database if exists p_Gra_3C;

Create database if not exists p_Gra_3C;

Use p_Gra_3C;

Drop table if exists Usuario;
Drop table if exists Hiperbola;
Drop table if exists Parabola;
Drop table if exists Elipse;
Drop table if exists Circunferencia;
Drop table if exists Figura;

Create table if not exists Usuario(
Usuario Varchar(10) Not Null Primary Key,
Contraseña Varchar(9) not null,
Grado Varchar(3) not null
);
create table if not exists Hiperbola(
IDH int(5) not null auto_increment primary key,
Usuario Varchar(10),
Fecha varchar(20),
Hora varchar(20),
VerticeX float(10),
VerticeY float(10),
Foco1X float(10),
Foco1Y float(10),
Foco2X float(10),
Foco2Y float(10),
CentroX float(10),
CentroY float(10),
Ecuacion varchar(10)
);
create table if not exists Parabola(
IDP int(5) not null auto_increment primary key,
Usuario Varchar(10) not null,
Fecha date not null,
Hora time not null,
VerticeX float(10) ,
VerticeY float(10) ,
FocoX float(10),
FocoY float(10),
Ecuacion varchar(20) ,
EcuacionGeneral varchar(20)
);
create table if not exists Elipse(
IDE int(5) not null auto_increment primary key,
Usuario Varchar(10) not null,
Fecha Varchar(20) not null,
Hora Varchar(20) not null,
PuntoIX float(10),
PuntoIY float(10),
PuntoFX float(10),
PuntoFY float(10),
Ancho float(10),
Alto float(10),
EcuacionGeneral varchar(20) , 
Ecuacion Varchar(20)
);
create table if not exists Circunferencia(
IDC int(5) not null auto_increment primary key,
Usuario Varchar(10) not null,
Fecha Varchar(20) not null,
Hora Varchar(20) not null,
CentroX int(10),
CentroY int(10),
PuntoTanX varchar(20),
PuntoTanY varchar(20),
EcuacionGen varchar(20),
EcuacionOrdi varchar(20)
);
Show Tables;
set global time_zone="+00:00";