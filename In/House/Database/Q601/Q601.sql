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
