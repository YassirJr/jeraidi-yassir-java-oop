create database if not exists tp5;

use tp5;

create table if not exists departements
(
    id  int primary key auto_increment,
    nom varchar(25) not null unique
);

create table if not exists professeurs
(
    id               int primary key auto_increment,
    nom              varchar(255) not null,
    prenom           varchar(255) not null,
    cin              varchar(10)  not null,
    adresse          varchar(255) not null,
    email            varchar(255) not null unique,
    telephone        varchar(10)  not null unique,
    date_recrutement date         not null,
    departement_id   int,
    foreign key (departement_id) references departements (id)
);