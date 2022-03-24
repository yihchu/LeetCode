<h1>查找重复的电子邮箱</h1>

编写一个SQL查询，查找Person表中所有重复的电子邮箱。

示例：</br>
+----+---------+</br>
| Id | Email   |</br>
+----+---------+</br>
| 1  | a@b.com |</br>
| 2  | c@d.com |</br>
| 3  | a@b.com |</br>
+----+---------+</br>

根据以上输入，你的查询应返回以下结果：

+---------+</br>
| Email   |</br>
+---------+</br>
| a@b.com |</br>
+---------+</br>

说明：所有电子邮箱都是小写字母。

Create table If Not Exists Person (id int, email varchar(255))</br>
Truncate table Person</br>
insert into Person (id, email) values ('1', 'a@b.com')</br>
insert into Person (id, email) values ('2', 'c@d.com')</br>
insert into Person (id, email) values ('3', 'a@b.com')</br>

[Link](https://leetcode-cn.com/problems/duplicate-emails/)