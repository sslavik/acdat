/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Vyacheslav Shylyayev
 * Created: 6 feb. 2020
 */

create database if not exists orm_empleado;

grant all on orm_empleado.* to acdat identified by "1234";

use orm_empleado;

create table if not exists empleado (
    dni varchar(10) primary key,
    nom_emp varchar(100),
    tipo varchar(2)
);

create table if not exists emp_plantilla (
    num_emp integer primary key auto_increment
);




