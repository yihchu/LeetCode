<h1>变更性别</h1>

Salary表：</br>
+-------------+----------+</br>
| Column Name | Type     |</br>
+-------------+----------+</br>
| id          | int      |</br>
| name        | varchar  |</br>
| sex         | ENUM     |</br>
| salary      | int      |</br>
+-------------+----------+</br>
id是这个表的主键。</br>
sex这一列的值是ENUM类型，只能从('m', 'f')中取。</br>
本表包含公司雇员的信息。</br>

请你编写一个SQL查询来交换所有的'f'和'm'（即，将所有'f'变为'm'，反之亦然），仅使用单个update语句，且不产生中间临时表。</br>
注意，你必须仅使用一条update语句，且不能使用select语句。</br>
查询结果如下例所示：</br>

Salary表：</br>
+----+------+-----+--------+</br>
| id | name | sex | salary |</br>
+----+------+-----+--------+</br>
| 1  | A    | m   | 2500   |</br>
| 2  | B    | f   | 1500   |</br>
| 3  | C    | m   | 5500   |</br>
| 4  | D    | f   | 500    |</br>
+----+------+-----+--------+</br>

Result表：</br>
+----+------+-----+--------+</br>
| id | name | sex | salary |</br>
+----+------+-----+--------+</br>
| 1  | A    | f   | 2500   |</br>
| 2  | B    | m   | 1500   |</br>
| 3  | C    | f   | 5500   |</br>
| 4  | D    | m   | 500    |</br>
+----+------+-----+--------+</br>
(1, A)和(3, C)从'm'变为'f'。</br>
(2, B)和(4, D)从'f'变为'm'。</br>

Create table If Not Exists Salary (id int, name varchar(100), sex char(1), salary int)</br>
Truncate table salary</br>
insert into salary (id, name, sex, salary) values ('1', 'A', 'm', '2500')</br>
insert into salary (id, name, sex, salary) values ('2', 'B', 'f', '1500')</br>
insert into salary (id, name, sex, salary) values ('3', 'C', 'm', '5500')</br>
insert into salary (id, name, sex, salary) values ('4', 'D', 'f', '500')</br>

[Link](https://leetcode-cn.com/problems/swap-salary/)