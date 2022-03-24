<h1>超过5名学生的课</h1>

有一个courses表，有: student(学生)和class(课程)。</br>
请列出所有超过或等于5名学生的课。</br>

例如，表：</br>
+---------+------------+</br>
| student | class      |</br>
+---------+------------+</br>
| A       | Math       |</br>
| B       | English    |</br>
| C       | Math       |</br>
| D       | Biology    |</br>
| E       | Math       |</br>
| F       | Computer   |</br>
| G       | Math       |</br>
| H       | Math       |</br>
| I       | Math       |</br>
+---------+------------+</br>

应该输出:</br>
+---------+</br>
| class   |</br>
+---------+</br>
| Math    |</br>
+---------+</br>

提示：</br>
学生在每个课中不应被重复计算。</br>

Create table If Not Exists Courses (student varchar(255), class varchar(255))</br>
Truncate table Courses</br>
insert into Courses (student, class) values ('A', 'Math')</br>
insert into Courses (student, class) values ('B', 'English')</br>
insert into Courses (student, class) values ('C', 'Math')</br>
insert into Courses (student, class) values ('D', 'Biology')</br>
insert into Courses (student, class) values ('E', 'Math')</br>
insert into Courses (student, class) values ('F', 'Computer')</br>
insert into Courses (student, class) values ('G', 'Math')</br>
insert into Courses (student, class) values ('H', 'Math')</br>
insert into Courses (student, class) values ('I', 'Math')</br>

[Link](https://leetcode-cn.com/problems/classes-more-than-5-students/)