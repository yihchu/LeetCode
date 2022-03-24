<h1>行程和用户</h1>

表：Trips</br>
+-------------+----------+</br>
| Column Name | Type     |</br>
+-------------+----------+</br>
| Id          | int      |</br>
| Client_Id   | int      |</br>
| Driver_Id   | int      |</br>
| City_Id     | int      |</br>
| Status      | enum     |</br>
| Request_at  | date     |</br>
+-------------+----------+</br>
Id是这张表的主键。</br>
这张表中存所有出租车的行程信息。每段行程有唯一Id，其中Client_Id和Driver_Id是Users表中Users_Id的外键。</br>
Status是一个表示行程状态的枚举类型，枚举成员为(‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’)。</br>

表：Users</br>
+-------------+----------+</br>
| Column Name | Type     |</br>
+-------------+----------+</br>
| Users_Id    | int      |</br>
| Banned      | enum     |</br>
| Role        | enum     |</br>
+-------------+----------+</br>
Users_Id是这张表的主键。</br>
这张表中存所有用户，每个用户都有一个唯一的Users_Id，Role是一个表示用户身份的枚举类型，枚举成员为(‘client’, ‘driver’, ‘partner’)。</br>
Banned是一个表示用户是否被禁止的枚举类型，枚举成员为(‘Yes’, ‘No’)。</br>

写一段SQL语句查出"2013-10-01"至"2013-10-03"期间非禁止用户（乘客和司机都必须未被禁止）的取消率。非禁止用户即Banned为No的用户，禁止用户即Banned为Yes的用户。</br>
取消率的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量)/(非禁止用户生成的订单总数)。</br>
返回结果表中的数据可以按任意顺序组织。其中取消率Cancellation Rate需要四舍五入保留两位小数 。</br>

查询结果格式如下例所示：</br>
Trips表：</br>
+----+-----------+-----------+---------+---------------------+------------+</br>
| Id | Client_Id | Driver_Id | City_Id | Status              | Request_at |</br>
+----+-----------+-----------+---------+---------------------+------------+</br>
| 1  | 1         | 10        | 1       | completed           | 2013-10-01 |</br>
| 2  | 2         | 11        | 1       | cancelled_by_driver | 2013-10-01 |</br>
| 3  | 3         | 12        | 6       | completed           | 2013-10-01 |</br>
| 4  | 4         | 13        | 6       | cancelled_by_client | 2013-10-01 |</br>
| 5  | 1         | 10        | 1       | completed           | 2013-10-02 |</br>
| 6  | 2         | 11        | 6       | completed           | 2013-10-02 |</br>
| 7  | 3         | 12        | 6       | completed           | 2013-10-02 |</br>
| 8  | 2         | 12        | 12      | completed           | 2013-10-03 |</br>
| 9  | 3         | 10        | 12      | completed           | 2013-10-03 |</br>
| 10 | 4         | 13        | 12      | cancelled_by_driver | 2013-10-03 |</br>
+----+-----------+-----------+---------+---------------------+------------+</br>

Users表：</br>
+----------+--------+--------+</br>
| Users_Id | Banned | Role   |</br>
+----------+--------+--------+</br>
| 1        | No     | client |</br>
| 2        | Yes    | client |</br>
| 3        | No     | client |</br>
| 4        | No     | client |</br>
| 10       | No     | driver |</br>
| 11       | No     | driver |</br>
| 12       | No     | driver |</br>
| 13       | No     | driver |</br>
+----------+--------+--------+</br>

Result表：</br>
+------------+-------------------+</br>
| Day        | Cancellation Rate |</br>
+------------+-------------------+</br>
| 2013-10-01 | 0.33              |</br>
| 2013-10-02 | 0.00              |</br>
| 2013-10-03 | 0.50              |</br>
+------------+-------------------+</br>

2013-10-01：</br>
- 共有4条请求，其中2条取消。</br>
- 然而，Id = 2的请求是由禁止用户（User_Id=2）发出的，所以计算时应当忽略它。</br>
- 因此，总共有3条非禁止请求参与计算，其中1条取消。</br>
- 取消率为(1 / 3) = 0.33</br>
  2013-10-02：</br>
- 共有3条请求，其中0条取消。</br>
- 然而，Id = 6的请求是由禁止用户发出的，所以计算时应当忽略它。</br>
- 因此，总共有2条非禁止请求参与计算，其中0条取消。</br>
- 取消率为(0 / 2) = 0.00</br>
  2013-10-03：</br>
- 共有3条请求，其中1条取消。</br>
- 然而，Id = 8的请求是由禁止用户发出的，所以计算时应当忽略它。</br>
- 因此，总共有2条非禁止请求参与计算，其中1条取消。</br>
- 取消率为(1 / 2) = 0.50</br>

Create table If Not Exists Trips (id int, client_id int, driver_id int, city_id int, status ENUM('completed', 'cancelled_by_driver', 'cancelled_by_client'), request_at varchar(50))</br>
Create table If Not Exists Users (users_id int, banned varchar(50), role ENUM('client', 'driver', 'partner'))</br>
Truncate table Trips</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('1', '1', '10', '1', 'completed', '2013-10-01')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('2', '2', '11', '1', 'cancelled_by_driver', '2013-10-01')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('3', '3', '12', '6', 'completed', '2013-10-01')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('4', '4', '13', '6', 'cancelled_by_client', '2013-10-01')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('5', '1', '10', '1', 'completed', '2013-10-02')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('6', '2', '11', '6', 'completed', '2013-10-02')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('7', '3', '12', '6', 'completed', '2013-10-02')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('8', '2', '12', '12', 'completed', '2013-10-03')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('9', '3', '10', '12', 'completed', '2013-10-03')</br>
insert into Trips (id, client_id, driver_id, city_id, status, request_at) values ('10', '4', '13', '12', 'cancelled_by_driver', '2013-10-03')</br>
Truncate table Users</br>
insert into Users (users_id, banned, role) values ('1', 'No', 'client')</br>
insert into Users (users_id, banned, role) values ('2', 'Yes', 'client')</br>
insert into Users (users_id, banned, role) values ('3', 'No', 'client')</br>
insert into Users (users_id, banned, role) values ('4', 'No', 'client')</br>
insert into Users (users_id, banned, role) values ('10', 'No', 'driver')</br>
insert into Users (users_id, banned, role) values ('11', 'No', 'driver')</br>
insert into Users (users_id, banned, role) values ('12', 'No', 'driver')</br>
insert into Users (users_id, banned, role) values ('13', 'No', 'driver')</br>

[Link](https://leetcode-cn.com/problems/trips-and-users/)