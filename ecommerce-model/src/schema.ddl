
    create table Order (
        id_order integer not null,
        purchase_data varchar(255),
        email varchar(255),
        total float not null,
        primary key (id)
    );

    create table Product (
        id_product integer not null,
        description varchar(255),
        availability integer not null,
        price double precision not null,
        type varchar(255),
        primary key (id)
    );

    create table User (
        email varchar(255) not null,
        surname varchar(255),
        name varchar(255),
        password varchar(255),
        username varchar(255),
        primary key (email)
    );
