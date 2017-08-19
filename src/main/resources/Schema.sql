
    drop table if exists monitoreo_detalle;

    create table monitoreo_detalle (
        ID bigint not null auto_increment,
        VERSION bigint not null DEFAULT 0,
        corriente_continua float not null,
        corriente_interna float not null,
        corriente_red float not null,
        desfasaje float not null,
        estado bit not null,
        fecha datetime not null,
        frecuencia_corriente float not null,
        frecuencia_tension float not null,
        hora time not null,
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
