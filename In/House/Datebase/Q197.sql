# Write your MySQL query statement below

SELECT w1.id FROM Weather w1 join Weather w2 on DATE_SUB(w1.recordDate, INTERVAL 1 DAY) = w2.recordDate where w1.temperature > w2.temperature;

/**
Title: 上升的温度
Link: https://leetcode-cn.com/problems/rising-temperature/

表Weather
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| recordDate    | date    |
| temperature   | int     |
+---------------+---------+
id是这个表的主键
该表包含特定日期的温度信息

编写一个SQL查询，来查找与之前（昨天的）日期相比温度更高的所有日期的id。
返回结果不要求顺序。

查询结果格式如下例：
Weather
+----+------------+-------------+
| id | recordDate | Temperature |
+----+------------+-------------+
| 1  | 2015-01-01 | 10          |
| 2  | 2015-01-02 | 25          |
| 3  | 2015-01-03 | 20          |
| 4  | 2015-01-04 | 30          |
+----+------------+-------------+
Result table:
+----+
| id |
+----+
| 2  |
| 4  |
+----+
2015-01-02的温度比前一天高（10 -> 25）
2015-01-04的温度比前一天高（20 -> 30）

Create table If Not Exists Weather (id int, recordDate date, temperature int)
Truncate table Weather
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10')
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25')
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20')
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30')
*/