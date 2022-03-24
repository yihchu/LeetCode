<h1>部门工资前三高的所有员工</h1>

Employee表包含所有员工信息，每个员工有其对应的工号Id，姓名Name，工资Salary和部门编号DepartmentId。</br>
+----+-------+--------+--------------+</br>
| Id | Name  | Salary | DepartmentId |</br>
+----+-------+--------+--------------+</br>
| 1  | Joe   | 85000  | 1            |</br>
| 2  | Henry | 80000  | 2            |</br>
| 3  | Sam   | 60000  | 2            |</br>
| 4  | Max   | 90000  | 1            |</br>
| 5  | Janet | 69000  | 1            |</br>
| 6  | Randy | 85000  | 1            |</br>
| 7  | Will  | 70000  | 1            |</br>
+----+-------+--------+--------------+</br>

Department表包含公司所有部门的信息。</br>
+----+----------+</br>
| Id | Name     |</br>
+----+----------+</br>
| 1  | IT       |</br>
| 2  | Sales    |</br>
+----+----------+</br>

编写一个SQL查询，找出每个部门获得前三高工资的所有员工。例如，根据上述给定的表，查询结果应返回：</br>
+------------+----------+--------+</br>
| Department | Employee | Salary |</br>
+------------+----------+--------+</br>
| IT         | Max      | 90000  |</br>
| IT         | Randy    | 85000  |</br>
| IT         | Joe      | 85000  |</br>
| IT         | Will     | 70000  |</br>
| Sales      | Henry    | 80000  |</br>
| Sales      | Sam      | 60000  |</br>
+------------+----------+--------+</br>

解释：
IT部门中，Max获得了最高的工资，Randy和Joe都拿到了第二高的工资，Will的工资排第三。销售部门（Sales）只有两名员工，Henry的工资最高，Sam的工资排第二。

Create table If Not Exists Employee (id int, name varchar(255), salary int, departmentId int)</br>
Create table If Not Exists Department (id int, name varchar(255))</br>
Truncate table Employee</br>
insert into Employee (id, name, salary, departmentId) values ('1', 'Joe', '85000', '1')</br>
insert into Employee (id, name, salary, departmentId) values ('2', 'Henry', '80000', '2')</br>
insert into Employee (id, name, salary, departmentId) values ('3', 'Sam', '60000', '2')</br>
insert into Employee (id, name, salary, departmentId) values ('4', 'Max', '90000', '1')</br>
insert into Employee (id, name, salary, departmentId) values ('5', 'Janet', '69000', '1')</br>
insert into Employee (id, name, salary, departmentId) values ('6', 'Randy', '85000', '1')</br>
insert into Employee (id, name, salary, departmentId) values ('7', 'Will', '70000', '1')</br>
Truncate table Department</br>
insert into Department (id, name) values ('1', 'IT')</br>
insert into Department (id, name) values ('2', 'Sales')</br>

[Link](https://leetcode-cn.com/problems/department-top-three-salaries/)