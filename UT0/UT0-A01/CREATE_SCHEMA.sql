CREATE TABLE EMPLEADO (
	idEmp int primary key,
    dni varchar(10) not null,
    nombre varchar(50) not null,
    fecNac date not null,
    codDep int  not null
) ;
    
CREATE TABLE DEPARTAMENTO (
	codDep int primary key,
    nombre varchar(50) not null,
    numDesp int not null,
	codJefe int references EMPLEADO(idEmp)
);
    
alter TABLE EMPLEADO ADD foreign key EMPLEADO(codDep)    references DEPARTAMENTO(codDep);
-- fin creacion estructura