# Write your MySQL query statement below

SELECT class FROM Courses group by class having count(distinct(student)) >= 5;

/**
Ques: 超过5名学生的课
Link: https://leetcode-cn.com/problems/classes-more-than-5-students/

有一个courses表，有: student(学生)和class(课程)。
请列出所有超过或等于5名学生的课。

例如，表：
+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+

应该输出:
+---------+
| class   |
+---------+
| Math    |
+---------+

提示：
学生在每个课中不应被重复计算。

Create table If Not Exists Courses (student varchar(255), class varchar(255))
Truncate table Courses
insert into Courses (student, class) values ('A', 'Math')
insert into Courses (student, class) values ('B', 'English')
insert into Courses (student, class) values ('C', 'Math')
insert into Courses (student, class) values ('D', 'Biology')
insert into Courses (student, class) values ('E', 'Math')
insert into Courses (student, class) values ('F', 'Computer')
insert into Courses (student, class) values ('G', 'Math')
insert into Courses (student, class) values ('H', 'Math')
insert into Courses (student, class) values ('I', 'Math')
*/