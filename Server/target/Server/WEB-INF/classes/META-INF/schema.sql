create table ROL (
    id int  not null, 
    nombre varchar(100), 
    descripcion varchar(255), 
    primary key (id)
);

create table PARAMETRO_SISTEMA (
	id int  not null,
	nombre varchar(50),
	valor varchar(255), 
	primary key (id)
);

create table DEPARTAMENTO (
	id int  not null,
	codigo varchar(100),
	nombre varchar(255),
	primary key (id)
);

create table MUNICIPIO (
	id int  not null,
	codigo varchar(100),
	nombre varchar(255),
	id_departamento int not null,
	primary key (id),
	foreign key (id_departamento) references departamento(id)
);

create table TIPOS_CUENTA(
        id int not null,
        nombre varchar(100),
        descripcion varchar(400),
        taza_interes float(3,3),
        primary key(id)
);

create table USUARIO (
	id int  not null, 
	codigo varchar(255), 
	email varchar(255), 
	nombre varchar(255), 
	password varchar(255), 
	telefono varchar(255),
	id_rol int not null,
	primary key (id),
	foreign key (id_rol) references rol(id)
);

create table CLIENTE (
        id int not null,
        nombre varchar(200),
        direccion varchar(200),
        id_muni int not null,
        nit varchar(15),
        fecha_nacimiento date,
        primary key(id),
        foreign key(id_muni) references municipio(id)
);

create table CUENTA(
        id int not null,
        moneda varchar(5),
        id_cliente int not null,
        id_tipocuenta int not null,
        fecha_apertura date,
        activo int,
        primary key(id),
        foreign key(id_cliente) references cliente(id),
        foreign key(id_tipocuenta) references tipos_cuenta(id)
);

create table TRANSACCION(
        id int not null,
        id_cuenta int not null,
        fecha date,
        monto decimal(10,2),
        tipo_transcaccion varchar(10),
        primary key(id),
        foreign key(id_cuenta) references cuenta(id)
);

