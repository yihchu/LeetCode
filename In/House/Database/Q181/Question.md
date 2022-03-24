<h1>超过经理收入的员工</h1>

SQL架构</br>
Employee表包含所有员工，他们的经理也属于员工。每个员工都有一个Id，此外还有一列对应员工的经理的Id。</br>
+----+-------+--------+-----------+</br>
| Id | Name  | Salary | ManagerId |</br>
+----+-------+--------+-----------+</br>
| 1  | Joe   | 70000  | 3         |</br>
| 2  | Henry | 80000  | 4         |</br>
| 3  | Sam   | 60000  | NULL      |</br>
| 4  | Max   | 90000  | NULL      |</br>
+----+-------+--------+-----------+</br>

给定Employee表，编写一个SQL查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe是唯一一个收入超过他的经理的员工。

+----------+</br>
| Employee |</br>
+----------+</br>
| Joe      |</br>
+----------+</br>

Create table If Not Exists Employee (id int, name varchar(255), salary int, managerId int)</br>
Truncate table Employee</br>
insert into Employee (id, name, salary, managerId) values ('1', 'Joe', '70000', '3')</br>
insert into Employee (id, name, salary, managerId) values ('2', 'Henry', '80000', '4')</br>
insert into Employee (id, name, salary, managerId) values ('3', 'Sam', '60000', 'None')</br>
insert into Employee (id, name, salary, managerId) values ('4', 'Max', '90000', 'None')</br>

[Link](https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/)