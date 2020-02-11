/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Vyacheslav Shylyayev
 * Created: 6 feb. 2020
 */

create table if not exists emp_plantilla (
    num_emp integer primary key,
    foreign key (num_emp) references empleado (num_emp)
);

alter table empleado add tipo varchar(2);
alter table empleado add num_emp integer;



