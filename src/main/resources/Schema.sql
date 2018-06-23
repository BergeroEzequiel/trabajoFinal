
    alter table alertas 
        drop 
        foreign key FK_pma5c5olv1akpqv2hui6v847k;

    alter table alertas 
        drop 
        foreign key FK_hkthp7wkpch9lkgxkoeistjrc;

    alter table alertas 
        drop 
        foreign key FK_f2vvcg8y37s832viqnvv1c5oi;

    alter table monitoreo_detalle 
        drop 
        foreign key FK_58u00fqpnvf9s4mgwcknkft1h;

    alter table monitoreo_procesado 
        drop 
        foreign key FK_44a9ciuvf4eccmymykurkai35;

    alter table umbrales 
        drop 
        foreign key FK_d7vtnlc37w5na0rtdcr8msaow;

    alter table umbrales 
        drop 
        foreign key FK_bg9as49r6n2y0lc492m5oj6px;

    alter table umbrales 
        drop 
        foreign key FK_4avl17cmusu1mjclhtx1x90f0;

    drop table if exists alertas;

    drop table if exists criticidades;

    drop table if exists monitoreo_detalle;

    drop table if exists monitoreo_procesado;

    drop table if exists nodos;

    drop table if exists umbrales;

    drop table if exists unidades_medida;

    drop table if exists usuarios;

    create table alertas (
        ID bigint not null auto_increment,
        descripcion varchar(50) not null,
        fecha datetime not null,
        hora time not null,
        valor float,
        variable_afectada varchar(50) not null,
        visualizar BOOLEAN DEFAULT false not null,
        id_criticidad bigint,
        id_nodo bigint,
        id_umbral bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table criticidades (
        ID bigint not null auto_increment,
        cantidad_repeticiones integer,
        periodo_tiempo varchar(255),
        prioridad varchar(255) not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table monitoreo_detalle (
        ID bigint not null auto_increment,
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
        tipo_procesamiento integer not null,
        id_nodo bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table nodos (
        ID bigint not null auto_increment,
        activo BOOLEAN DEFAULT true not null,
        descripcion varchar(250) not null,
        moludo varchar(50) not null,
        numero integer not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table umbrales (
        tipo_umbral varchar(31) not null,
        ID bigint not null auto_increment,
        activo BOOLEAN DEFAULT true not null,
        nombre_variable varchar(50) not null,
        ultima_modificacion date not null,
        valor_max float not null,
        valor_min float not null,
        id_criticidad bigint,
        id_um bigint,
        id_nodo bigint,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table unidades_medida (
        ID bigint not null auto_increment,
        factor_conversion float not null,
        nombre varchar(255) not null,
        primary key (ID)
    ) ENGINE=InnoDB;

    create table usuarios (
        ID bigint not null auto_increment,
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

    alter table alertas 
        add constraint FK_pma5c5olv1akpqv2hui6v847k 
        foreign key (id_criticidad) 
        references criticidades (ID);

    alter table alertas 
        add constraint FK_hkthp7wkpch9lkgxkoeistjrc 
        foreign key (id_nodo) 
        references nodos (ID);

    alter table alertas 
        add constraint FK_f2vvcg8y37s832viqnvv1c5oi 
        foreign key (id_umbral) 
        references umbrales (ID);

    alter table monitoreo_detalle 
        add constraint FK_58u00fqpnvf9s4mgwcknkft1h 
        foreign key (id_nodo) 
        references nodos (ID);

    alter table monitoreo_procesado 
        add constraint FK_44a9ciuvf4eccmymykurkai35 
        foreign key (id_nodo) 
        references nodos (ID);

    alter table umbrales 
        add constraint FK_d7vtnlc37w5na0rtdcr8msaow 
        foreign key (id_criticidad) 
        references criticidades (ID);

    alter table umbrales 
        add constraint FK_bg9as49r6n2y0lc492m5oj6px 
        foreign key (id_um) 
        references unidades_medida (ID);

    alter table umbrales 
        add constraint FK_4avl17cmusu1mjclhtx1x90f0 
        foreign key (id_nodo) 
        references nodos (ID);
