create table role
(
    id        bigint auto_increment
        primary key,
    role_name varchar(45) not null
);

insert into role (role_name) VALUE ('ROLE_USER');
insert into role (role_name) VALUE ('ROLE_ADMIN');
insert into role (role_name) VALUE ('ROLE_MANAGER');

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

insert into type_genre(genre_name) value ('Genre unknown');
insert into type_genre(genre_name) value ('Fantasy');
insert into type_genre(genre_name) value ('Autobiography');
insert into type_genre(genre_name) value ('Science-fiction');
insert into type_genre(genre_name) value ('Historical novels');
insert into type_genre(genre_name) value ('Detective stories');
insert into type_genre(genre_name) value ('Thrillers and horrors');
insert into type_genre(genre_name) value ('Romance');

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

insert into book(bookName, author, ISBN, genre_id) VALUE ('«Fellowship of the Ring»','John R. R. Tolkien','5-352-00312-4',1);
insert into book(bookName, author, ISBN, genre_id) VALUE ('«Pride and Prejudice»','Jane Austen','978-5-04-106641-3',1);
insert into book(bookName, author, ISBN, genre_id) VALUE ('«His Dark Materials»','Philip Pullman','5-353-01207-1',1);
insert into book(bookName, author, ISBN, genre_id) VALUE ('«The Ultimate Hitchhiker\'s Guide»','Douglas Adams','978-5-17-032458-3',1);
insert into book(bookName, author, ISBN, genre_id) VALUE ('«The Philosophy of Java»','Bruce Eckel','978-5-4461-1107-7',1);

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

