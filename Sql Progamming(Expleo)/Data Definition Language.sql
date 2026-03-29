#This is for using all DDL commands like create, alter, drop, truncate, rename
SELECT * FROM studentTable;

create table studenttable(
studentId varchar(10),
name varchar(20),
age int,
email varchar(20),
DOB date,
major varchar(20)
);
alter table studenttable add column Phone varchar(10);
alter table studenttable add column DepartmentId varchar(20);
alter table studenttable add column (Address varchar(100),Gender varchar(1));

alter table studenttable drop column phone;

alter table studenttable modify column address varchar(150);

alter table studenttable rename column name to fullname;

truncate table studenttable;

rename table student to StudentTable;



