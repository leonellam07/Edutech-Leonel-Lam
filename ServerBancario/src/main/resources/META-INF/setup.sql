    insert into ROL (id,nombre,descripcion) values (1, 'ADMIN', 'Administrador del Sistema');
    insert into ROL (id,nombre,descripcion) values (2, 'NORM', 'Normal');

    insert into tipos_cuenta (id,nombre,descripcion,taza_interes) values (1,'ahorro normal',null,0.05);
    insert into tipos_cuenta (id,nombre,descripcion,taza_interes) values (2,'ahorro plazo fijo',null,0.12);
    insert into tipos_cuenta (id,nombre,descripcion,taza_interes) values (3,'monetaria',null,0.02);

    insert into PARAMETRO_SISTEMA (id,nombre, valor) VALUES (1, 'MODO_DEBUG', '0');
    insert into PARAMETRO_SISTEMA (id,nombre,valor) VALUES (2, 'NUMERO_DECIMALES', '2');

    insert into DEPARTAMENTO (id,codigo,nombre) values (1, 'GUA', 'Guatemala');
    insert into DEPARTAMENTO (id,codigo,nombre) values (2, 'CHQ', 'Chiquimula');

    insert into MUNICIPIO (id,codigo,nombre,ID_DEPARTAMENTO) values (1, 'CAP', 'Capital', 1);
    insert into MUNICIPIO (id,codigo,nombre,ID_DEPARTAMENTO) values (2, 'MXC', 'Mixco', 1);
    insert into MUNICIPIO (id,codigo,nombre,ID_DEPARTAMENTO) values (3, 'VLN', 'Villa Nueva', 1);
    insert into MUNICIPIO (id,codigo,nombre,ID_DEPARTAMENTO) values (4, 'CHQ', 'Chiquimula', 2);
    insert into MUNICIPIO (id,codigo,nombre,ID_DEPARTAMENTO) values (5, 'JOC', 'Jocotan', 2);
    insert into MUNICIPIO (id,codigo,nombre,ID_DEPARTAMENTO) values (6, 'ESQ', 'Esquipulas', 2);

    INSERT INTO tarjeta_debito(id,descripcion,fechaExpiracion,limitexDia,numero,pin) values (1,null,'2025-01-01',5000,'123456','1234');
    INSERT INTO tarjeta_debito(id,descripcion,fechaExpiracion,limitexDia,numero,pin) values (2,null,'2025-01-01',8000,'136790','4567');
    INSERT INTO tarjeta_debito(id,descripcion,fechaExpiracion,limitexDia,numero,pin) values (3,null,'2025-01-01',6000,'245678','9012');
    INSERT INTO tarjeta_debito(id,descripcion,fechaExpiracion,limitexDia,numero,pin) values (4,null,'2025-01-01',7000,'678991','4567');
    INSERT INTO tarjeta_debito(id,descripcion,fechaExpiracion,limitexDia,numero,pin) values (5,null,'2025-01-01',6000,'467891','2341');
    INSERT INTO tarjeta_debito(id,descripcion,fechaExpiracion,limitexDia,numero,pin) values (6,null,'2025-01-01',7000,'982341','4353');

    insert into cliente (id,nombre,direccion,ID_MUNI,nit,fecha_nacimiento,id_tarjetaDebito) values (1, 'Nahum Alarcon','Ciudad',1,'1234124', '1981-07-23',1);
    insert into cliente (id,nombre,direccion,ID_MUNI,nit,fecha_nacimiento,id_tarjetaDebito) values (2, 'Yoli Esteban','Zona 4',3, '3423423','1987-05-25',2);
    insert into cliente (id,nombre,direccion,ID_MUNI,nit,fecha_nacimiento,id_tarjetaDebito) values (3, 'Jorge Leonel Lam Pazos','Zona 6',2,'534563', '1994-01-07',3);
    insert into cliente (id,nombre,direccion,ID_MUNI,nit,fecha_nacimiento,id_tarjetaDebito) values (4, 'Manuel Mutzus','Centro Zona 1', 4,'3456456','1987-01-02',4);
    insert into cliente (id,nombre,direccion,ID_MUNI,nit,fecha_nacimiento,id_tarjetaDebito) values (5, 'Alejandro Rigalt','Zona 2',5,'57456567','1978-02-08',5);
    insert into cliente (id,nombre,direccion,ID_MUNI,nit,fecha_nacimiento,id_tarjetaDebito) values (6, 'Bern Torres','Zona 3',6,'4567567','1980-01-01',6);


    insert into usuario (id,codigo,email,nombre,password,telefono,ID_CLIENTE) values (1, 'admin', 'admin@admon.com',  'Administrador del Sistema',  '12345', '1234124',1);
    insert into usuario (id,codigo,email,nombre,password,telefono,ID_CLIENTE) values (2, 'yesteban', 'yesteban09@gmail.com',  'Yoli Esteban',  '67890', '3423423',2);
    insert into usuario (id,codigo,email,nombre,password,telefono,ID_CLIENTE) values (3, 'jlpazos', 'leokirap014@gmail.com',  'Jorge Leonel Lam Pazos', 'abcde', '534563',3);
    insert into usuario (id,codigo,email,nombre,password,telefono,ID_CLIENTE) values (4, 'mmutzus', 'elmutzus@gmail.com',   'Manuel Mutzus',  'fghij', '3456456',4);
    insert into usuario (id,codigo,email,nombre,password,telefono,ID_CLIENTE) values (5, 'arigalt', 'arigalt@gmail.com',  'Alejandro Rigalt',  'a1b2c3', '57456567',5);
    insert into usuario (id,codigo,email,nombre,password,telefono,ID_CLIENTE) values (6, 'btorres', 'bernyt0rr3s@gmail.com',   'Bern Torres',  'd4e5f6', '4567567', 6);

    INSERT INTO asignacion_rol(descripcion,fechaAsignacion,id_usuario,id_rol) VALUES (null,'2010-01-10',1,1);
    INSERT INTO asignacion_rol(descripcion,fechaAsignacion,id_usuario,id_rol) VALUES (null,'2010-01-10',2,2);
    INSERT INTO asignacion_rol(descripcion,fechaAsignacion,id_usuario,id_rol) VALUES (null,'2010-01-10',3,2);
    INSERT INTO asignacion_rol(descripcion,fechaAsignacion,id_usuario,id_rol) VALUES (null,'2010-01-10',4,2);
    INSERT INTO asignacion_rol(descripcion,fechaAsignacion,id_usuario,id_rol) VALUES (null,'2010-01-10',5,2);
    INSERT INTO asignacion_rol(descripcion,fechaAsignacion,id_usuario,id_rol) VALUES (null,'2010-01-10',6,2);

    insert into cuenta (id, moneda,ID_CLIENTE,ID_TIPOCUENTA,fecha_apertura,activo) values (1,'QTZ',1,1,'2010-01-10',1);
    insert into cuenta (id, moneda,ID_CLIENTE,ID_TIPOCUENTA,fecha_apertura,activo) values (2,'QTZ',2,2,'2010-02-11',1);
    insert into cuenta (id, moneda,ID_CLIENTE,ID_TIPOCUENTA,fecha_apertura,activo) values (3,'QTZ',3,3,'2010-03-12',1);
    insert into cuenta (id, moneda,ID_CLIENTE,ID_TIPOCUENTA,fecha_apertura,activo) values (4,'QTZ',4,1,'2010-04-13',1);
    insert into cuenta (id, moneda,ID_CLIENTE,ID_TIPOCUENTA,fecha_apertura,activo) values (5,'QTZ',5,2,'2010-05-14',1);
    insert into cuenta (id, moneda,ID_CLIENTE,ID_TIPOCUENTA,fecha_apertura,activo) values (6,'QTZ',6,3,'2010-06-15',1);

    INSERT INTO tipo_transaccion(id,descripcion,nombre) VALUES (1,'Retiro normal','retiro');
    INSERT INTO tipo_transaccion(id,descripcion,nombre) VALUES (2,'Deposito normal','deposito');
    INSERT INTO tipo_transaccion(id,descripcion,nombre) VALUES (3,'Transferencia de cuenta a cuenta','tranferencia');

    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (1,'2018-01-11',5000,1,1);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (2,'2018-01-11',6000,1,2);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (3,'2018-01-11',7000,1,3);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (4,'2018-01-11',8000,1,4);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (5,'2018-01-11',9000,1,5);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (6,'2018-01-11',8000,1,6);

    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (7,'2018-01-13',-100,2,1);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (8,'2018-01-12',-200,2,2);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (9,'2018-01-15',-100,2,3);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (10,'2018-01-13',-300,2,4);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (11,'2018-01-09',-400,2,5);
    INSERT INTO transaccion(id,fecha,monto,id_tipoTransaccion,ID_CUENTA) values (12,'2018-01-10',-150,2,6);

    

    Commit;
