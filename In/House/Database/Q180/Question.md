<h1>连续出现的数字</h1>

表：Logs</br>
+-------------+---------+</br>
| Column Name | Type    |</br>
+-------------+---------+</br>
| id          | int     |</br>
| num         | varchar |</br>
+-------------+---------+</br>
id是这个表的主键。
编写一个SQL查询，查找所有至少连续出现三次的数字。
返回的结果表中的数据可以按任意顺序排列。
查询结果格式如下面的例子所示：

Logs表：</br>
+----+-----+</br>
| Id | Num |</br>
+----+-----+</br>
| 1  | 1   |</br>
| 2  | 1   |</br>
| 3  | 1   |</br>
| 4  | 2   |</br>
| 5  | 1   |</br>
| 6  | 2   |</br>
| 7  | 2   |</br>
+----+-----+</br>

Result表：</br>
+-----------------+</br>
| ConsecutiveNums |</br>
+-----------------+</br>
| 1               |</br>
+-----------------+</br>
1是唯一连续出现至少三次的数字。

Create table If Not Exists Logs (id int, num int)</br>
Truncate table Logs</br>
insert into Logs (id, num) values ('1', '1')</br>
insert into Logs (id, num) values ('2', '1')</br>
insert into Logs (id, num) values ('3', '1')</br>
insert into Logs (id, num) values ('4', '2')</br>
insert into Logs (id, num) values ('5', '1')</br>
insert into Logs (id, num) values ('6', '2')</br>
insert into Logs (id, num) values ('7', '2')</br>

[Link](https://leetcode-cn.com/problems/consecutive-numbers/)