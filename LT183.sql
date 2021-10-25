
# Write your MySQL query statement below

select c.Name as Customers from Orders o right join Customers c on o.CustomerId = c.Id where o.CustomerId is null;

/**
Link: https://leetcode-cn.com/problems/customers-who-never-order/

某网站包含两个表，Customers表和Orders表。编写一个SQL查询，找出所有从不订购任何东西的客户。

Customers表：
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+

Orders表：
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+

例如给定上述表格，你的查询应返回：
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
*/