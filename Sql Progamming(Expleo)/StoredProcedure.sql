

#using the database
use dharshan;

#creating a delimiter and using stored procedure
CREATE TABLE employee (
    E_id INT PRIMARY KEY,
    Name VARCHAR(40),
    Dept VARCHAR(40)
);

#inserting values into a table using stored procedure
delimiter @@
create procedure insert_employee (
in p_id int,
in p_name varchar(40),
in p_dept varchar(40)
)
begin
insert into employee (E_id,Name,Dept)
values(p_id,p_name,p_dept);
end @@
delimiter ;

#to show the stored procedure status
show procedure status where Db = 'employee';

#to get values from the stored procedure
delimiter %%
create procedure get_all_employees()
begin
select * from employee;
end %%
delimiter ;

#to update values in stored Procedure
DELIMITER $$
CREATE PROCEDURE update_employee(
    IN p_id INT,
    IN p_dept VARCHAR(40)
)
BEGIN 
    UPDATE employee 
    SET dept = p_dept 
    WHERE E_id = p_id;
END $$
DELIMITER ;

#to delete a values in stored procedure
delimiter @@
create procedure delete_employee(
in p_id int
)
begin 
delete from employee
where E_id = p_id;
end @@
delimiter ;

#create procedure to get employee by id
delimiter $$
create procedure get_employee_by_id (
in p_id int,
out o_name varchar(40),
out o_dept varchar(40)
)
begin 
select Name, Dept into o_name,o_dept
from employee
where E_id = p_id;
end $$
delimiter ;


