
CREATE DATABASE bdcoches;
use bdcoches;
create user usrcoches;
alter user usrcoches identified by '12345';


CREATE TABLE coche (
	matricula varchar(8) primary key,
    marca varchar(50) not null,
    modelo varchar(50) not null, 
    color varchar(50) not null
);
 GRANT ALL PRIVILEGES ON bdcoches to usrcoches;
 GRANT SELECT, UPDATE, DELETE, INSERT ON coche TO usrcoches;
 