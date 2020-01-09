/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Vyacheslav Shylyayev
 * Created: 9 ene. 2020
 */

create database if not exists comunidades_db;

use comunidades_db;

create table if not exists comunidad (
    id_com integer primary key auto_increment,
    nom_com varchar(255) not null
);

create table if not exists provincia(
    id_prov integer primary key,
    nom_prov varchar(255) not null,
    comunidad integer not null,

    foreign key (comunidad) references comunidad(id_com) on update cascade
);

create table if not exists localidad (
    id_loc integer primary key auto_increment,
    nom_localidad varchar(255) not null,
    provincia integer not null,

    foreign key (provincia) references provincia(id_prov) on update cascade

);

