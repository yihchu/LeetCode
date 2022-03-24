# Write your MySQL query statement below

select Email from Person p1 group by p1.Email having count(*) > 1
