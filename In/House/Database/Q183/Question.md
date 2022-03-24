<h1>从不订购的客户</h1>

某网站包含两个表，Customers表和Orders表。编写一个SQL查询，找出所有从不订购任何东西的客户。

Customers表：</br>
+----+-------+</br>
| Id | Name  |</br>
+----+-------+</br>
| 1  | Joe   |</br>
| 2  | Henry |</br>
| 3  | Sam   |</br>
| 4  | Max   |</br>
+----+-------+</br>

Orders表：</br>
+----+------------+</br>
| Id | CustomerId |</br>
+----+------------+</br>
| 1  | 3          |</br>
| 2  | 1          |</br>
+----+------------+</br>

例如给定上述表格，你的查询应返回：</br>
+-----------+</br>
| Customers |</br>
+-----------+</br>
| Henry     |</br>
| Max       |</br>
+-----------+</br>

Create table If Not Exists Customers (id int, name varchar(255))</br>
Create table If Not Exists Orders (id int, customerId int)</br>
Truncate table Customers</br>
insert into Customers (id, name) values ('1', 'Joe')</br>
insert into Customers (id, name) values ('2', 'Henry')</br>
insert into Customers (id, name) values ('3', 'Sam')</br>
insert into Customers (id, name) values ('4', 'Max')</br>
Truncate table Orders</br>
insert into Orders (id, customerId) values ('1', '3')</br>
insert into Orders (id, customerId) values ('2', '1')</br>

[Link](https://leetcode-cn.com/problems/customers-who-never-order/)