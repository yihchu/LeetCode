# Write your MySQL query statement below

select max(e2.Salary) as SecondHighestSalary from Employee e1 left join Employee e2 on e1.Salary > e2.Salary;

# 官方答案用的limit offset

/**
Title: 第二高的薪水
Link: https://leetcode-cn.com/problems/second-highest-salary/

编写一个SQL查询，获取Employee表中第二高的薪水（Salary）。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述Employee表，SQL查询应该返回200作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回null。

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

Create table If Not Exists Employee (id int, salary int)
Truncate table Employee
insert into Employee (id, salary) values ('1', '100')
insert into Employee (id, salary) values ('2', '200')
insert into Employee (id, salary) values ('3', '300')
*/