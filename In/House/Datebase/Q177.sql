
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE OFST INTEGER(30);
    SET OFST = N - 1;

    RETURN (
        # Write your MySQL query statement below.
        select max(Salary) as F
        from (select distinct(Salary) from Employee
        order by Salary desc
        limit 1 offset OFST) t
        );
END

/**
Ques: 第N高的薪水
Link: https://leetcode-cn.com/problems/nth-highest-salary/

编写一个SQL查询，获取Employee表中第n高的薪水(Salary）。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述Employee表，n=2时，应返回第二高的薪水200。如果不存在第n高的薪水，那么查询应返回null。

+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+

Create table If Not Exists Scores (id int, score DECIMAL(3,2))
Truncate table Scores
insert into Scores (id, score) values ('1', '3.5')
insert into Scores (id, score) values ('2', '3.65')
insert into Scores (id, score) values ('3', '4.0')
insert into Scores (id, score) values ('4', '3.85')
insert into Scores (id, score) values ('5', '4.0')
insert into Scores (id, score) values ('6', '3.65')

*/