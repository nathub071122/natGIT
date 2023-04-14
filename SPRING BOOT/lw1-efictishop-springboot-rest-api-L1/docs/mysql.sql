CREATE SCHEMA `EFSNATDB` ;
CREATE SCHEMA `EFSNATDB` ;
USE EFSNATDB;
SELECT * FROM EMPLOYEES;
create table employees_DEL (employee_id integer not null, first_name varchar(255) not null, salary integer not null, primary key (employee_id)) engine=InnoDB;
create table hibernate_sequence_DEL (next_val bigint) engine=InnoDB
SELECT * FROM HIBERNATE_SEQUENCE;
INSERT INTO EMPLOYEES VALUES (100,'JOHN',50);
INSERT INTO EMPLOYEES VALUES (102,'JOHNNY',500);