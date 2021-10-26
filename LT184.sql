# Write your MySQL query statement below

select sub.DNM, emp.Name, emp.Salary
from leetcode.Employee3 emp join
     (SELECT max(e.Salary) as SALR, d.Id as DID, d.Name as DNM FROM leetcode.Employee3 e join leetcode.Department d on e.DepartmentId = d.Id group by d.Id) as sub
     on emp.DepartmentId = sub.DID
where emp.Salary = sub.SALR;

/**
Link: https://leetcode-cn.com/problems/department-highest-salary/

Employee表包含所有员工信息，每个员工有其对应的Id, salary和department Id。
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Jim   | 90000  | 1            |
| 3  | Henry | 80000  | 2            |
| 4  | Sam   | 60000  | 2            |
| 5  | Max   | 90000  | 1            |
+----+-------+--------+--------------+

Department表包含公司所有部门的信息。
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+

编写一个SQL查询，找出每个部门工资最高的员工。对于上述表，您的SQL查询应返回以下行（行的顺序无关紧要）。
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Jim      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

解释：
Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。

Create table If Not Exists Employee (id int, name varchar(255), salary int, departmentId int)
Create table If Not Exists Department (id int, name varchar(255))
Truncate table Employee
insert into Employee (id, name, salary, departmentId) values ('1', 'Joe', '70000', '1')
insert into Employee (id, name, salary, departmentId) values ('2', 'Jim', '90000', '1')
insert into Employee (id, name, salary, departmentId) values ('3', 'Henry', '80000', '2')
insert into Employee (id, name, salary, departmentId) values ('4', 'Sam', '60000', '2')
insert into Employee (id, name, salary, departmentId) values ('5', 'Max', '90000', '1')
Truncate table Department
insert into Department (id, name) values ('1', 'IT')
insert into Department (id, name) values ('2', 'Sales')
*/