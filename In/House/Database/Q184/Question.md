<h1>部门工资最高的员工</h1>

Employee表包含所有员工信息，每个员工有其对应的Id, salary和department Id。</br>
+----+-------+--------+--------------+</br>
| Id | Name  | Salary | DepartmentId |</br>
+----+-------+--------+--------------+</br>
| 1  | Joe   | 70000  | 1            |</br>
| 2  | Jim   | 90000  | 1            |</br>
| 3  | Henry | 80000  | 2            |</br>
| 4  | Sam   | 60000  | 2            |</br>
| 5  | Max   | 90000  | 1            |</br>
+----+-------+--------+--------------+</br>

Department表包含公司所有部门的信息。</br>
+----+----------+</br>
| Id | Name     |</br>
+----+----------+</br>
| 1  | IT       |</br>
| 2  | Sales    |</br>
+----+----------+</br>

编写一个SQL查询，找出每个部门工资最高的员工。对于上述表，您的SQL查询应返回以下行（行的顺序无关紧要）。</br>
+------------+----------+--------+</br>
| Department | Employee | Salary |</br>
+------------+----------+--------+</br>
| IT         | Max      | 90000  |</br>
| IT         | Jim      | 90000  |</br>
| Sales      | Henry    | 80000  |</br>
+------------+----------+--------+</br>

解释：
Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。

Create table If Not Exists Employee (id int, name varchar(255), salary int, departmentId int)</br>
Create table If Not Exists Department (id int, name varchar(255))</br>
Truncate table Employee</br>
insert into Employee (id, name, salary, departmentId) values ('1', 'Joe', '70000', '1')</br>
insert into Employee (id, name, salary, departmentId) values ('2', 'Jim', '90000', '1')</br>
insert into Employee (id, name, salary, departmentId) values ('3', 'Henry', '80000', '2')</br>
insert into Employee (id, name, salary, departmentId) values ('4', 'Sam', '60000', '2')</br>
insert into Employee (id, name, salary, departmentId) values ('5', 'Max', '90000', '1')</br>
Truncate table Department</br>
insert into Department (id, name) values ('1', 'IT')</br>
insert into Department (id, name) values ('2', 'Sales')</br>

[Link](https://leetcode-cn.com/problems/department-highest-salary/)