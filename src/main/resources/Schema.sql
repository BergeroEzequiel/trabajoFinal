
    alter table monitoreo_detalle 
        drop 
        foreign key FK_58u00fqpnvf9s4mgwcknkft1h;

    drop table if exists alertas;

    drop table if exists monitoreo_detalle;

    drop table if exists monitoreo_procesado;

    drop table if exists nodos;

    drop table if exists umbrales;

    drop table if exists umbrales_especificos;

    drop table if exists usuarios;

    create table alertas (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        descripcion varchar(50) not null,
        fecha datetime not null,
        hora time not null,
        nodo_afectado integer not null,
        umbral_superado float not null,
        valor float not null,
        variable_afectada varchar(50) not null,
        visualizar BOOLEAN DEFAULT true not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table monitoreo_detalle (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        corriente_continua float not null,
        corriente_interna float not null,
        corriente_red float not null,
        desfasaje float not null,
        estado varchar(255) not null,
        estado_control bit not null,
        fecha datetime,
        frecuencia_corriente float not null,
        frecuencia_tension float not null,
        hora time,
        humedad float not null,
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
        id_nodo bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table monitoreo_procesado (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        corriente_continua_avg float not null,
        corriente_continua_max float not null,
        corriente_continua_min float not null,
        corriente_interna_avg float not null,
        corriente_interna_max float not null,
        corriente_interna_min float not null,
        corriente_red_avg float not null,
        corriente_red_max float not null,
        corriente_red_min float not null,
        desfasaje_avg float not null,
        desfasaje_max float not null,
        desfasaje_min float not null,
        frecuencia_corriente_avg float not null,
        frecuencia_corriente_max float not null,
        frecuencia_corriente_min float not null,
        frecuencia_tension_avg float not null,
        frecuencia_tension_max float not null,
        frecuencia_tension_min float not null,
        humedad_avg float not null,
        humedad_max float not null,
        humedad_min float not null,
        ip_nodo integer,
        potencia_continua_avg float not null,
        potencia_continua_max float not null,
        potencia_continua_min float not null,
        potencia_interna_avg float not null,
        potencia_interna_max float not null,
        potencia_interna_min float not null,
        potencia_red_avg float not null,
        potencia_red_max float not null,
        potencia_red_min float not null,
        pvm_avg float not null,
        pvm_max float not null,
        pvm_min float not null,
        temperatura1_avg float not null,
        temperatura1_max float not null,
        temperatura1_min float not null,
        temperatura2_avg float not null,
        temperatura2_max float not null,
        temperatura2_min float not null,
        temperatura3_avg float not null,
        temperatura3_max float not null,
        temperatura3_min float not null,
        temperatura4_avg float not null,
        temperatura4_max float not null,
        temperatura4_min float not null,
        temperatura5_avg float not null,
        temperatura5_max float not null,
        temperatura5_min float not null,
        tension_continua_avg float not null,
        tension_continua_max float not null,
        tension_continua_min float not null,
        tension_interna_avg float not null,
        tension_interna_max float not null,
        tension_interna_min float not null,
        tension_red_avg float not null,
        tension_red_max float not null,
        tension_red_min float not null,
        tension_tierra_avg float not null,
        tension_tierra_max float not null,
        tension_tierra_min float not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table nodos (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        activo BOOLEAN DEFAULT true not null,
        descripcion varchar(250) not null,
        moludo varchar(50) not null,
        numero integer not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table umbrales (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        activo BOOLEAN DEFAULT true not null,
        nombre_variable varchar(50) not null,
        tipo integer,
        ultima_modificacion datetime not null,
        valor_max float not null,
        valor_min float not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table umbrales_especificos (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        activo BOOLEAN DEFAULT true not null,
        id_nodo bigint,
        nombre_variable varchar(50) not null,
        tipo integer,
        ultima_modificacion datetime not null,
        valor_max float not null,
        valor_min float not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table usuarios (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        apellido varchar(50) not null,
        email varchar(200) not null,
        estado_sistema bit not null,
        nombre varchar(50) not null,
        nombre_cuenta varchar(50) not null,
        password varchar(16) not null,
        rol varchar(200) not null,
        ultima_coneccion datetime not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    alter table monitoreo_detalle 
        add constraint FK_58u00fqpnvf9s4mgwcknkft1h 
        foreign key (id_nodo) 
        references nodos (ID);
