-- eje1
select * from usuarios order by nombre;
-- eje2
select d.codDep, d.nombre, count(*) "Número de empleados"
from departamento d inner join empleado e on d.coddep=e.coddep
group by e.codDep, d.nombre;
-- opcion 2 del ejer2
select d.codDep, d.nombre, count(*) as NúmeroEmpleados
from departamento d inner join empleado e on d.coddep=e.coddep
group by e.codDep, d.nombre;

-- eje3     numero de empleados del departamento de ventas
select count(*) "Numero de empleados del departamento de ventas entas"
from departamento d inner join empleado e on d.coddep=e.coddep
where d.nombre='Ventas'
group by e.codDep;

-- eje4  Salario medio de cada departamento:

select d.codDep, d.nombre, avg(e.salario)
from departamento d inner join empleado e on d.coddep=e.coddep
group by d.codDep,d.nombre;