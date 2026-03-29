insert into studenttable (studentId, fullname, age,email,DOB,major,phone,DepartmentId,Address,gender)
values("su001","Jaggu",22,"jaggu@gmail.com","2005-03-10","computer science","9089786756","cse1","Mettur dam,mettur,tamilnadu","M");

set sql_safe_updates = 0;
update studenttable  set major = "cse" where fullname = "Jaggu";
