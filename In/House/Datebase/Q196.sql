# Write your MySQL query statement below

# 注意看这道题的提示部分，说要是用delete语句，还有执行sql后输出的是整张表
# 刚开始我就没看懂，寻思，不就是一个查询么，干啥要delete？既然是有条件的查询，为啥还说输出整张表，以后出题人好像有点什么大病。
# 然后写了一个sql，怎么看都觉得没问题，然后就提交了，结果应该是两条，但是本地好好地，扔上去就输出三条，我还以为我自己瞎了。
# (select min(Id) Id, Email from Person group by Email)
# 看了看评论，才明白，你妹，一个查询你让我删数据！！
# 然后再看一遍题，哦，原来写的就是"删除Person表中所有重复的电子邮箱"。
# 原来有大病的是自己。

delete p from Person p left join (select min(Id) NID from Person group by Email) as s on p.Id = s.NID where s.NID is null;

/**
Ques: 删除重复的电子邮箱
Link: https://leetcode-cn.com/problems/delete-duplicate-emails/

编写一个SQL查询，来删除Person表中所有重复的电子邮箱，重复的邮箱里只保留Id最小的那个。

+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id是这个表的主键。

例如，在运行你的查询语句之后，上面的Person表应返回以下几行:
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+

提示：
执行SQL之后，输出是整个Person表。
使用delete语句。

Create table If Not Exists Person (Id int, Email varchar(255))
Truncate table Person
insert into Person (id, email) values ('1', 'john@example.com')
insert into Person (id, email) values ('2', 'bob@example.com')
insert into Person (id, email) values ('3', 'john@example.com')
*/