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

/**
Title: 行程和用户
Link: https://leetcode-cn.com/problems/trips-and-users/

表：Trips
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| Id          | int      |
| Client_Id   | int      |
| Driver_Id   | int      |
| City_Id     | int      |
| Status      | enum     |
| Request_at  | date     |
+-------------+----------+
Id是这张表的主键。
这张表中存所有出租车的行程信息。每段行程有唯一Id，其中Client_Id和Driver_Id是Users表中Users_Id的外键。
Status是一个表示行程状态的枚举类型，枚举成员为(‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’)。

表：Users
+-------------+----------+
| Column Name | Type     |
+-------------+----------+
| Users_Id    | int      |
| Banned      | enum     |
| Role        | enum     |
+-------------+----------+
Users_Id是这张表的主键。
这张表中存所有用户，每个用户都有一个唯一的Users_Id，Role是一个表示用户身份的枚举类型，枚举成员为(‘client’, ‘driver’, ‘partner’)。
Banned是一个表示用户是否被禁止的枚举类型，枚举成员为(‘Yes’, ‘No’)。

写一段SQL语句查出"2013-10-01"至"2013-10-03"期间非禁止用户（乘客和司机都必须未被禁止）的取消率。非禁止用户即Banned为No的用户，禁止用户即Banned为Yes的用户。
取消率的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量)/(非禁止用户生成的订单总数)。
返回结果表中的数据可以按任意顺序组织。其中取消率Cancellation Rate需要四舍五入保留两位小数 。

查询结果格式如下例所示：
Trips表：
+----+-----------+-----------+---------+---------------------+------------+
| Id | Client_Id | Driver_Id | City_Id | Status              | Request_at |
+----+-----------+-----------+---------+---------------------+------------+
| 1  | 1         | 10        | 1       | completed           | 2013-10-01 |
| 2  | 2         | 11        | 1       | cancelled_by_driver | 2013-10-01 |
| 3  | 3         | 12        | 6       | completed           | 2013-10-01 |
| 4  | 4         | 13        | 6       | cancelled_by_client | 2013-10-01 |
| 5  | 1         | 10        | 1       | completed           | 2013-10-02 |
| 6  | 2         | 11        | 6       | completed           | 2013-10-02 |
| 7  | 3         | 12        | 6       | completed           | 2013-10-02 |
| 8  | 2         | 12        | 12      | completed           | 2013-10-03 |
| 9  | 3         | 10        | 12      | completed           | 2013-10-03 |
| 10 | 4         | 13        | 12      | cancelled_by_driver | 2013-10-03 |
+----+-----------+-----------+---------+---------------------+------------+

Users表：
+----------+--------+--------+
| Users_Id | Banned | Role   |
+----------+--------+--------+
| 1        | No     | client |
| 2        | Yes    | client |
| 3        | No     | client |
| 4        | No     | client |
| 10       | No     | driver |
| 11       | No     | driver |
| 12       | No     | driver |
| 13       | No     | driver |
+----------+--------+--------+

Result表：
+------------+-------------------+
| Day        | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 | 0.33              |
| 2013-10-02 | 0.00              |
| 2013-10-03 | 0.50              |
+------------+-------------------+

2013-10-01：
  - 共有4条请求，其中2条取消。
  - 然而，Id = 2的请求是由禁止用户（User_Id=2）发出的，所以计算时应当忽略它。
  - 因此，总共有3条非禁止请求参与计算，其中1条取消。
  - 取消率为(1 / 3) = 0.33
2013-10-02：
  - 共有3条请求，其中0条取消。
  - 然而，Id = 6的请求是由禁止用户发出的，所以计算时应当忽略它。
  - 因此，总共有2条非禁止请求参与计算，其中0条取消。
  - 取消率为(0 / 2) = 0.00
2013-10-03：
  - 共有3条请求，其中1条取消。
  - 然而，Id = 8的请求是由禁止用户发出的，所以计算时应当忽略它。
  - 因此，总共有2条非禁止请求参与计算，其中1条取消。
  - 取消率为(1 / 2) = 0.50

Create table If Not Exists Trips (id int, client_id int, driver_id int, city_id int, status ENUM('completed', 'cancelled_by_driver', 'cancelled_by_client'), request_at varchar(50))
Create table If Not Exists Users (users_id int, banned varchar(50), role ENUM('client', 'driver', 'partner'))
Truncate table Trips
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('1', '1', '10', '1', 'completed', '2013-10-01')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('2', '2', '11', '1', 'cancelled_by_driver', '2013-10-01')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('3', '3', '12', '6', 'completed', '2013-10-01')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('4', '4', '13', '6', 'cancelled_by_client', '2013-10-01')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('5', '1', '10', '1', 'completed', '2013-10-02')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('6', '2', '11', '6', 'completed', '2013-10-02')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('7', '3', '12', '6', 'completed', '2013-10-02')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('8', '2', '12', '12', 'completed', '2013-10-03')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('9', '3', '10', '12', 'completed', '2013-10-03')
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('10', '4', '13', '12', 'cancelled_by_driver', '2013-10-03')
Truncate table Users
insert into Users (users_id, banned, role) values ('1', 'No', 'client')
insert into Users (users_id, banned, role) values ('2', 'Yes', 'client')
insert into Users (users_id, banned, role) values ('3', 'No', 'client')
insert into Users (users_id, banned, role) values ('4', 'No', 'client')
insert into Users (users_id, banned, role) values ('10', 'No', 'driver')
insert into Users (users_id, banned, role) values ('11', 'No', 'driver')
insert into Users (users_id, banned, role) values ('12', 'No', 'driver')
insert into Users (users_id, banned, role) values ('13', 'No', 'driver')
*/