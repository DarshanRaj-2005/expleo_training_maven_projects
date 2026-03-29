#This is to use constraints like primary key, unique, foreign key,  not null, default, check
create table department(
DepartmentId varchar(20)unique primary key,
Name varchar(20) not null,
building varchar(30)
);

alter table department drop primary kestudenty;
alter table department add constraint PK_Department primary key(DepartmentId);

alter table department modify column building varchar(30) default'Nil';

select * from department;
select * from course;

drop table department;

create table course(
CourseId varchar(10) primary key,
title varchar(20) not null,
Credits int check(Credits > 0),
DepartmentId varchar(10),
foreign key(DepartmentId) references Department(DepartmentId)
);

drop table course;


