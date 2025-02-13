create table user
(
    create_at   datetime(6)  null,
    id          bigint auto_increment
        primary key,
    modified_at datetime(6)  null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    username    varchar(255) not null
);

create table todo
(
    create_at   datetime(6)  null,
    id          bigint auto_increment
        primary key,
    modified_at datetime(6)  null,
    user_id     bigint       null,
    contents    longtext     null,
    title       varchar(255) not null,
    username    varchar(255) not null,
    constraint FK2ft3dfk1d3uw77pas3xqwymm7
        foreign key (user_id) references user (id)
);
