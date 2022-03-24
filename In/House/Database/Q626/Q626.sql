# Write your MySQL query statement below

select s1.id, if(s1.id % 2 = 1, if(s2.student is not null, s2.student, s1.student), s3.student) student
from Seat s1 left join Seat s2 on s1.id + 1 = s2.id
             left join Seat s3 on s1.id = s3.id + 1
