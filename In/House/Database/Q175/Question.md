<h1>组合两个表</h1>


SQL架构:

表1: Person</br>
+-------------+---------+</br>
| 列名         | 类型     |</br>
+-------------+---------+</br>
| PersonId    | int     |</br>
| FirstName   | varchar |</br>
| LastName    | varchar |</br>
+-------------+---------+</br>
PersonId是上表主键

表2: Address</br>
+-------------+---------+</br>
| 列名         | 类型    |</br>
+-------------+---------+</br>
| AddressId   | int     |</br>
| PersonId    | int     |</br>
| City        | varchar |</br>
| State       | varchar |</br>
+-------------+---------+</br>
AddressId是上表主键

编写一个SQL查询，满足条件：无论person是否有地址信息，都需要基于上述两表提供person的以下信息：
FirstName, LastName, City, State

Create table If Not Exists Person (PersonId int, FirstName varchar(255), LastName varchar(255))</br>
Create table If Not Exists Address (AddressId int, PersonId int, City varchar(255), State varchar(255))</br>
Truncate table Person</br>
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')</br>
insert into Person (PersonId, LastName, FirstName) values ('2', 'Alice', 'Bob')</br>
Truncate table Address</br>
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')</br>
insert into Address (AddressId, PersonId, City, State) values ('2', '3', 'Leetcode', 'California')</br>

[Link](https://leetcode-cn.com/problems/combine-two-tables/)