# Write your MySQL query statement below

Select P.FirstName, P.LastName, A.City, A.State
from Person P left join Address A on P.PersonId = A.PersonId

/**
Title: 组合两个表
Link: https://leetcode-cn.com/problems/combine-two-tables/

SQL架构:

表1: Person
+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId是上表主键

表2: Address
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId是上表主键

编写一个SQL查询，满足条件：无论person是否有地址信息，都需要基于上述两表提供person的以下信息：
FirstName, LastName, City, State

Create table If Not Exists Person (PersonId int, FirstName varchar(255), LastName varchar(255))
Create table If Not Exists Address (AddressId int, PersonId int, City varchar(255), State varchar(255))
Truncate table Person
insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')
insert into Person (PersonId, LastName, FirstName) values ('2', 'Alice', 'Bob')
Truncate table Address
insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')
insert into Address (AddressId, PersonId, City, State) values ('2', '3', 'Leetcode', 'California')

*/