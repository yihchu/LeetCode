# Write your MySQL query statement below

update salary set sex = if(sex = 'f', 'm', 'f')

/**
Ques: 变更性别
Link: https://leetcode-cn.com/problems/swap-salary/

Salary表：
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| id          | int      |
| name        | varchar  |
| sex         | ENUM     |
| salary      | int      |
+-------------+----------+
id是这个表的主键。
sex这一列的值是ENUM类型，只能从('m', 'f')中取。
本表包含公司雇员的信息。

请你编写一个SQL查询来交换所有的'f'和'm'（即，将所有'f'变为'm'，反之亦然），仅使用单个update语句，且不产生中间临时表。
注意，你必须仅使用一条update语句，且不能使用select语句。
查询结果如下例所示：

Salary表：
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |
+----+------+-----+--------+

Result表：
+----+------+-----+--------+
| id | name | sex | salary |
+----+------+-----+--------+
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |
+----+------+-----+--------+
(1, A)和(3, C)从'm'变为'f'。
(2, B)和(4, D)从'f'变为'm'。

Create table If Not Exists Salary (id int, name varchar(100), sex char(1), salary int)
Truncate table salary
insert into salary (id, name, sex, salary) values ('1', 'A', 'm', '2500')
insert into salary (id, name, sex, salary) values ('2', 'B', 'f', '1500')
insert into salary (id, name, sex, salary) values ('3', 'C', 'm', '5500')
insert into salary (id, name, sex, salary) values ('4', 'D', 'f', '500')

*/