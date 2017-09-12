
    alter table usuarios 
        drop 
        foreign key FK_ghgeehq52emllswr9plavf7bd;

    drop table if exists alertas;

    drop table if exists monitoreo_detalle;

    drop table if exists roles_usuario;

    drop table if exists umbrales;

    drop table if exists usuarios;

    create table alertas (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        codigo varchar(50) not null,
        descripcion varchar(50) not null,
        fecha date not null,
        hora time not null,
        nodo_afectado integer not null,
        umbral_superado float not null,
        variable_afectada varchar(50) not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table monitoreo_detalle (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        corriente_continua float not null,
        corriente_interna float not null,
        corriente_red float not null,
        desfasaje float not null,
        estado bit not null,
        fecha datetime,
        frecuencia_corriente float not null,
        frecuencia_tension float not null,
        hora time,
        humedad float not null,
        ip_nodo integer not null,
        potencia_continua float not null,
        potencia_interna float not null,
        potencia_red float not null,
        pvm float not null,
        temperatura1 float not null,
        temperatura2 float not null,
        temperatura3 float not null,
        temperatura4 float not null,
        temperatura5 float not null,
        tension_continua float not null,
        tension_interna float not null,
        tension_red float not null,
        tension_tierra float not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table roles_usuario (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        rol varchar(255) not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table umbrales (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        nombre_variable varchar(50) not null,
        ultima_modificacion date not null,
        valor_max float not null,
        valor_min float not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table usuarios (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        activo bit not null,
        apellido varchar(50) not null,
        email varchar(200) not null,
        nombre varchar(50) not null,
        nombre_cuenta varchar(50) not null,
        password varchar(16) not null,
        ultima_coneccion datetime not null,
        rol_id bigint not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table usuarios 
        add constraint FK_ghgeehq52emllswr9plavf7bd 
        foreign key (rol_id) 
        references roles_usuario (ID);
