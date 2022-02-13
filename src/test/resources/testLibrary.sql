
create table role
(
    id        bigint auto_increment
        primary key,
    role_name varchar(45) not null
);

create table status
(
    id          bigint auto_increment
        primary key,
    status_name varchar(45) not null
);

create table type_genre
(
    id         bigint auto_increment
        primary key,
    genre_name varchar(45) not null
);

create table book
(
    id       bigint auto_increment
        primary key,
    bookName varchar(45) not null,
    author   varchar(45) not null,
    ISBN     varchar(45) not null,
    genre_id bigint      not null,
    constraint type_genre
        foreign key (genre_id) references type_genre (id)
);

create index type_genre_idx
    on book (genre_id);

create table user
(
    id        bigint auto_increment
        primary key,
    user_name varchar(45) not null,
    role_id   bigint      not null,
    email     varchar(45) not null,
    password  varchar(255) not null,
    constraint role
        foreign key (role_id) references role (id)
);

create table log_record
(
    id          bigint auto_increment
        primary key,
    book_id     bigint      not null,
    user_id     bigint      not null,
    status_id   bigint      not null,
    create_date varchar(45) not null,
    close_date  varchar(45) not null,
    create_by   varchar(45) not null,
    constraint book_log
        foreign key (book_id) references book (id),
    constraint status
        foreign key (status_id) references status (id),
    constraint user_log
        foreign key (user_id) references user (id)
);

create index status_idx
    on log_record (status_id);

create index user_log_idx
    on log_record (user_id);

create index user_role_idx
    on user (role_id);

