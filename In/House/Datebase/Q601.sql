# Write your MySQL query statement below


# 解法有点笨，但是能通过
select * from Stadium where id in
(select s1.id from Stadium s1 join Stadium s2 on s1.id + 1 = s2.id join Stadium s3 on s2.id + 1 = s3.id where s1.people >= 100 and s2.people >= 100 and s3.people >= 100
union
select s1.id from Stadium s1 join Stadium s2 on s1.id = s2.id + 1 join Stadium s3 on s2.id = s3.id + 1 where s1.people >= 100 and s2.people >= 100 and s3.people >= 100
union
select s2.id from Stadium s1 join Stadium s2 on s1.id = s2.id + 1 join Stadium s3 on s2.id = s3.id + 1 where s1.people >= 100 and s2.people >= 100 and s3.people >= 100)


# 更好的解法
select t.id, t.visit_date, t.people
from (
         select tt.id, tt.visit_date, tt.people, count(*) over (partition by tt.r) c
         from (
                  select *, id - rank() over(order by id) r from Stadium where people >= 100
              ) as tt
     ) as t
where t.c >= 3


/**
Ques: 体育馆的人流量
Link: https://leetcode-cn.com/problems/human-traffic-of-stadium/

表：Stadium
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
visit_date是表的主键
每日人流量信息被记录在这三列信息中：序号(id)、日期(visit_date)、人流量(people)
每天只有一行记录，日期随着id的增加而增加

编写一个SQL查询以找出每行的人数大于或等于100且id连续的三行或更多行记录。
返回按visit_date升序排列的结果表。
查询结果格式如下所示。

Stadium table:
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+

Result table:
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+
id为5、6、7、8的四行id连续，并且每行都有>= 100的人数记录。
请注意，即使第7行和第8行的 visit_date不是连续的，输出也应当包含第8行，因为我们只需要考虑id连续的记录。
不输出id为2和3的行，因为至少需要三条id连续的记录。

Create table If Not Exists Stadium (id int, visit_date DATE NULL, people int)
Truncate table Stadium
insert into Stadium (id, visit_date, people) values ('1', '2017-01-01', '10')
insert into Stadium (id, visit_date, people) values ('2', '2017-01-02', '109')
insert into Stadium (id, visit_date, people) values ('3', '2017-01-03', '150')
insert into Stadium (id, visit_date, people) values ('4', '2017-01-04', '99')
insert into Stadium (id, visit_date, people) values ('5', '2017-01-05', '145')
insert into Stadium (id, visit_date, people) values ('6', '2017-01-06', '1455')
insert into Stadium (id, visit_date, people) values ('7', '2017-01-07', '199')
insert into Stadium (id, visit_date, people) values ('8', '2017-01-09', '188')
*/