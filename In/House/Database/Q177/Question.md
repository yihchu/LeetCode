<h1>第N高的薪水</h1>

编写一个SQL查询，获取Employee表中第n高的薪水(Salary）。

+----+--------+</br>
| Id | Salary |</br>
+----+--------+</br>
| 1  | 100    |</br>
| 2  | 200    |</br>
| 3  | 300    |</br>
+----+--------+</br>
例如上述Employee表，n=2时，应返回第二高的薪水200。如果不存在第n高的薪水，那么查询应返回null。

+------------------------+</br>
| getNthHighestSalary(2) |</br>
+------------------------+</br>
| 200                    |</br>
+------------------------+</br>

Create table If Not Exists Scores (id int, score DECIMAL(3,2))</br>
Truncate table Scores</br>
insert into Scores (id, score) values ('1', '3.5')</br>
insert into Scores (id, score) values ('2', '3.65')</br>
insert into Scores (id, score) values ('3', '4.0')</br>
insert into Scores (id, score) values ('4', '3.85')</br>
insert into Scores (id, score) values ('5', '4.0')</br>
insert into Scores (id, score) values ('6', '3.65')</br>

[Link](https://leetcode-cn.com/problems/nth-highest-salary/)