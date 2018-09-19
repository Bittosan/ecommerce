
    create table Order (
        id integer not null,
        data varchar(255),
        idUser varchar(255),
        total float not null,
        primary key (id)
    );

    create table Product (
        id integer not null,
        descrizione varchar(255),
        disponibilita integer not null,
        immagine varchar(255),
        prezzo double precision not null,
        tipo varchar(255),
        primary key (id)
    );

    create table User (
        email varchar(255) not null,
        cognome varchar(255),
        nome varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (email)
    );
