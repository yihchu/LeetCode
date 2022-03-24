# Write your MySQL query statement below
# 解法1
select t2.`Day`, round(ifnull(t1.tnuoc / t2.tnuoc, 0), 2) `Cancellation Rate` from
    (SELECT count(t.id) tnuoc, t.request_at `day` FROM Trips t join Users c on t.client_id = c.users_id join Users d on t.driver_id = d.users_id
     where t.status != 'completed' and c.banned = 'no' and d.banned = 'no' and t.request_at between '2013-10-01' and '2013-10-03'
     group by t.request_at) t1
        right join
    (SELECT count(t.id) tnuoc, t.request_at `day` FROM Trips t join Users c on t.client_id = c.users_id join Users d on t.driver_id = d.users_id
     where c.banned = 'no' and d.banned = 'no' and t.request_at between '2013-10-01' and '2013-10-03'
     group by t.request_at) t2
    on t1.`day` = t2.`day`;

# 解法2
SELECT t.request_at `Day`, round(sum(if(t.status != 'completed', 1, 0)) / count(t.id), 2) `Cancellation Rate` FROM Trips t join Users c on t.client_id = c.users_id join Users d on t.driver_id = d.users_id
where c.banned = 'no' and d.banned = 'no' and t.request_at between '2013-10-01' and '2013-10-03'
group by t.request_at;

