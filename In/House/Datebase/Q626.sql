# Write your MySQL query statement below

select s1.id, if(s1.id % 2 = 1, if(s2.student is not null, s2.student, s1.student), s3.student) student
from Seat s1 left join Seat s2 on s1.id + 1 = s2.id
             left join Seat s3 on s1.id = s3.id + 1

/**
Link: https://leetcode-cn.com/problems/exchange-seats/

小美是一所中学的信息科技老师，她有一张seat座位表，平时用来储存学生名字和与他们相对应的座位id。
其中纵列的id是连续递增的
小美想改变相邻俩学生的座位。
你能不能帮她写一个SQL query来输出小美想要的结果呢？

示例：
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+

假如数据输入的是上表，则输出结果如下：
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
注意：
如果学生人数是奇数，则不需要改变最后一个同学的座位。

Create table If Not Exists Seat (id int, student varchar(255))
Truncate table Seat
insert into Seat (id, student) values ('1', 'Abbot');
insert into Seat (id, student) values ('2', 'Doris');
insert into Seat (id, student) values ('3', 'Emerson');
insert into Seat (id, student) values ('4', 'Green');
insert into Seat (id, student) values ('5', 'Jeames');

*/