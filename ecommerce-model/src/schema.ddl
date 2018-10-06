
    create table Orders (
        id_order integer not null,
        id_product integer not null,
        email varchar(255),
        purchase_data varchar(255),
        quantity integer not null,
        total float not null,
        primary key (id_order, id_product)
    );

    create table OrdersLogger (
        id_order integer not null,
        id_product integer not null,
        email varchar(255),
        purchase_data varchar(255),
        primary key (id_order, id_product)
    );

    create table Product (
        id_product integer not null,
        availability integer not null,
        description varchar(255),
        image varchar(255),
        price double precision not null,
        type varchar(255),
        primary key (id_product)
    );

    create table User (
        email varchar(255) not null,
        name varchar(255),
        password varchar(255),
        surname varchar(255),
        username varchar(255),
        primary key (email)
    );
