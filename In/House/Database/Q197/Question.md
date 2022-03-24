<h1>升的温度</h1>

表Weather</br>
+---------------+---------+</br>
| Column Name   | Type    |</br>
+---------------+---------+</br>
| id            | int     |</br>
| recordDate    | date    |</br>
| temperature   | int     |</br>
+---------------+---------+</br>
id是这个表的主键</br>
该表包含特定日期的温度信息</br>

编写一个SQL查询，来查找与之前（昨天的）日期相比温度更高的所有日期的id。</br>
返回结果不要求顺序。</br>

查询结果格式如下例：</br>
Weather</br>
+----+------------+-------------+</br>
| id | recordDate | Temperature |</br>
+----+------------+-------------+</br>
| 1  | 2015-01-01 | 10          |</br>
| 2  | 2015-01-02 | 25          |</br>
| 3  | 2015-01-03 | 20          |</br>
| 4  | 2015-01-04 | 30          |</br>
+----+------------+-------------+</br>
Result table:</br>
+----+</br>
| id |</br>
+----+</br>
| 2  |</br>
| 4  |</br>
+----+</br>
2015-01-02的温度比前一天高（10 -> 25）</br>
2015-01-04的温度比前一天高（20 -> 30）</br>

Create table If Not Exists Weather (id int, recordDate date, temperature int)</br>
Truncate table Weather</br>
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10')</br>
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25')</br>
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20')</br>
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30')</br>

[Link](https://leetcode-cn.com/problems/rising-temperature/)