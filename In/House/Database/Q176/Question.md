<h1>第二高的薪水</h1>

编写一个SQL查询，获取Employee表中第二高的薪水（Salary）。

+----+--------+</br>
| Id | Salary |</br>
+----+--------+</br>
| 1  | 100    |</br>
| 2  | 200    |</br>
| 3  | 300    |</br>
+----+--------+</br>
例如上述Employee表，SQL查询应该返回200作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回null。

+---------------------+</br>
| SecondHighestSalary |</br>
+---------------------+</br>
| 200                 |</br>
+---------------------+</br>

Create table If Not Exists Employee (id int, salary int)</br>
Truncate table Employee</br>
insert into Employee (id, salary) values ('1', '100')</br>
insert into Employee (id, salary) values ('2', '200')</br>
insert into Employee (id, salary) values ('3', '300')</br>

[Link](https://leetcode-cn.com/problems/second-highest-salary/)