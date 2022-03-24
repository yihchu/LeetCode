# Write your MySQL query statement below

select d.Name Department, e1.Name Employee, e1.Salary from Employee e1 join Department d on e1.departmentId = d.id
where 3 > (select count(distinct(e2.Salary)) from Employee e2 where e1.departmentId = e2.departmentId and e2.Salary > e1.Salary);

