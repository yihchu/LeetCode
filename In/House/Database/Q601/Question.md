<h1>体育馆的人流量</h1>

表：Stadium</br>
+---------------+---------+</br>
| Column Name   | Type    |</br>
+---------------+---------+</br>
| id            | int     |</br>
| visit_date    | date    |</br>
| people        | int     |</br>
+---------------+---------+</br>
visit_date是表的主键</br>
每日人流量信息被记录在这三列信息中：序号(id)、日期(visit_date)、人流量(people)</br>
每天只有一行记录，日期随着id的增加而增加</br>

编写一个SQL查询以找出每行的人数大于或等于100且id连续的三行或更多行记录。</br>
返回按visit_date升序排列的结果表。</br>
查询结果格式如下所示。</br>

Stadium table:</br>
+------+------------+-----------+</br>
| id   | visit_date | people    |</br>
+------+------------+-----------+</br>
| 1    | 2017-01-01 | 10        |</br>
| 2    | 2017-01-02 | 109       |</br>
| 3    | 2017-01-03 | 150       |</br>
| 4    | 2017-01-04 | 99        |</br>
| 5    | 2017-01-05 | 145       |</br>
| 6    | 2017-01-06 | 1455      |</br>
| 7    | 2017-01-07 | 199       |</br>
| 8    | 2017-01-09 | 188       |</br>
+------+------------+-----------+</br>

Result table:</br>
+------+------------+-----------+</br>
| id   | visit_date | people    |</br>
+------+------------+-----------+</br>
| 5    | 2017-01-05 | 145       |</br>
| 6    | 2017-01-06 | 1455      |</br>
| 7    | 2017-01-07 | 199       |</br>
| 8    | 2017-01-09 | 188       |</br>
+------+------------+-----------+</br>
id为5、6、7、8的四行id连续，并且每行都有>= 100的人数记录。</br>
请注意，即使第7行和第8行的 visit_date不是连续的，输出也应当包含第8行，因为我们只需要考虑id连续的记录。</br>
不输出id为2和3的行，因为至少需要三条id连续的记录。</br>

Create table If Not Exists Stadium (id int, visit_date DATE NULL, people int)</br>
Truncate table Stadium</br>
insert into Stadium (id, visit_date, people) values ('1', '2017-01-01', '10')</br>
insert into Stadium (id, visit_date, people) values ('2', '2017-01-02', '109')</br>
insert into Stadium (id, visit_date, people) values ('3', '2017-01-03', '150')</br>
insert into Stadium (id, visit_date, people) values ('4', '2017-01-04', '99')</br>
insert into Stadium (id, visit_date, people) values ('5', '2017-01-05', '145')</br>
insert into Stadium (id, visit_date, people) values ('6', '2017-01-06', '1455')</br>
insert into Stadium (id, visit_date, people) values ('7', '2017-01-07', '199')</br>
insert into Stadium (id, visit_date, people) values ('8', '2017-01-09', '188')</br>

[Link](https://leetcode-cn.com/problems/human-traffic-of-stadium/)