# Write your MySQL query statement below

select distinct(l1.Num) as ConsecutiveNums from Logs l1, Logs l2, Logs l3
where l1.Id = l2.Id - 1 && l2.Id = l3.Id - 1 && l1.Num = l2.Num && l2.Num = l3.Num

/**
Link: https://leetcode-cn.com/problems/consecutive-numbers/

表：Logs
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| num         | varchar |
+-------------+---------+
id是这个表的主键。
编写一个SQL查询，查找所有至少连续出现三次的数字。
返回的结果表中的数据可以按任意顺序排列。
查询结果格式如下面的例子所示：

Logs表：
+----+-----+
| Id | Num |
+----+-----+
| 1  | 1   |
| 2  | 1   |
| 3  | 1   |
| 4  | 2   |
| 5  | 1   |
| 6  | 2   |
| 7  | 2   |
+----+-----+

Result表：
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
1是唯一连续出现至少三次的数字。

*/