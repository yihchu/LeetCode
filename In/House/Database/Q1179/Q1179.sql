# Write your MySQL query statement below

# # 超时
# select distinct(d.id),
#                (select d01.revenue from Department d01 where d01.id = d.id and d01.month = 'Jan' limit 1) as Jan_Revenue,
#                (select d02.revenue from Department d02 where d02.id = d.id and d02.month = 'Feb' limit 1) as Feb_Revenue,
#                (select d03.revenue from Department d03 where d03.id = d.id and d03.month = 'Mar' limit 1) as Mar_Revenue,
#                (select d04.revenue from Department d04 where d04.id = d.id and d04.month = 'Apr' limit 1) as Apr_Revenue,
#                (select d05.revenue from Department d05 where d05.id = d.id and d05.month = 'May' limit 1) as May_Revenue,
#                (select d06.revenue from Department d06 where d06.id = d.id and d06.month = 'Jun' limit 1) as Jun_Revenue,
#                (select d07.revenue from Department d07 where d07.id = d.id and d07.month = 'Jul' limit 1) as Jul_Revenue,
#                (select d08.revenue from Department d08 where d08.id = d.id and d08.month = 'Aug' limit 1) as Aug_Revenue,
#                (select d09.revenue from Department d09 where d09.id = d.id and d09.month = 'Sep' limit 1) as Sep_Revenue,
#                (select d10.revenue from Department d10 where d10.id = d.id and d10.month = 'Oct' limit 1) as Oct_Revenue,
#                (select d11.revenue from Department d11 where d11.id = d.id and d11.month = 'Nov' limit 1) as Nov_Revenue,
#                (select d12.revenue from Department d12 where d12.id = d.id and d12.month = 'Dec' limit 1) as Dec_Revenue
# from Department d where id in (select distinct(id) from Department)

select id
     , sum(if(month = 'Jan', revenue, null)) as 'Jan_Revenue'
     , sum(if(month = 'Feb', revenue, null)) as 'Feb_Revenue'
     , sum(if(month = 'Mar', revenue, null)) as 'Mar_Revenue'
     , sum(if(month = 'Apr', revenue, null)) as 'Apr_Revenue'
     , sum(if(month = 'May', revenue, null)) as 'May_Revenue'
     , sum(if(month = 'Jun', revenue, null)) as 'Jun_Revenue'
     , sum(if(month = 'Jul', revenue, null)) as 'Jul_Revenue'
     , sum(if(month = 'Aug', revenue, null)) as 'Aug_Revenue'
     , sum(if(month = 'Sep', revenue, null)) as 'Sep_Revenue'
     , sum(if(month = 'Oct', revenue, null)) as 'Oct_Revenue'
     , sum(if(month = 'Nov', revenue, null)) as 'Nov_Revenue'
     , sum(if(month = 'Dec', revenue, null)) as 'Dec_Revenue'
from Department group by id;
