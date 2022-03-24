<h1>删除重复的电子邮箱</h1>

编写一个SQL查询，来删除Person表中所有重复的电子邮箱，重复的邮箱里只保留Id最小的那个。

+----+------------------+</br>
| Id | Email            |</br>
+----+------------------+</br>
| 1  | john@example.com |</br>
| 2  | bob@example.com  |</br>
| 3  | john@example.com |</br>
+----+------------------+</br>
Id是这个表的主键。

例如，在运行你的查询语句之后，上面的Person表应返回以下几行:</br>
+----+------------------+</br>
| Id | Email            |</br>
+----+------------------+</br>
| 1  | john@example.com |</br>
| 2  | bob@example.com  |</br>
+----+------------------+</br>

提示：</br>
执行SQL之后，输出是整个Person表。</br>
使用delete语句。</br>

Create table If Not Exists Person (Id int, Email varchar(255))</br>
Truncate table Person</br>
insert into Person (id, email) values ('1', 'john@example.com')</br>
insert into Person (id, email) values ('2', 'bob@example.com')</br>
insert into Person (id, email) values ('3', 'john@example.com')</br>

[Link](https://leetcode-cn.com/problems/delete-duplicate-emails/)