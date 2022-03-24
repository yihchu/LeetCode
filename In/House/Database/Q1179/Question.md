<h1>>重新格式化部门表</h1>

部门表Department：</br>
+---------------+---------+</br>
| Column Name   | Type    |</br>
+---------------+---------+</br>
| id            | int     |</br>
| revenue       | int     |</br>
| month         | varchar |</br>
+---------------+---------+</br>
(id, month)是表的联合主键。</br>
这个表格有关于每个部门每月收入的信息。</br>
月份（month）可以取下列值["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]。</br>
编写一个SQL查询来重新格式化表，使得新的表中有一个部门id列和一些对应每个月的收入（revenue）列。</br>
查询结果格式如下面的示例所示：</br>

Department表：</br>
+------+---------+-------+</br>
| id   | revenue | month |</br>
+------+---------+-------+</br>
| 1    | 8000    | Jan   |</br>
| 2    | 9000    | Jan   |</br>
| 3    | 10000   | Feb   |</br>
| 1    | 7000    | Feb   |</br>
| 1    | 6000    | Mar   |</br>
+------+---------+-------+</br>

查询得到的结果表：</br>
+------+-------------+-------------+-------------+-----+-------------+</br>
| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |</br>
+------+-------------+-------------+-------------+-----+-------------+</br>
| 1    | 8000        | 7000        | 6000        | ... | null        |</br>
| 2    | 9000        | null        | null        | ... | null        |</br>
| 3    | null        | 10000       | null        | ... | null        |</br>
+------+-------------+-------------+-------------+-----+-------------+</br>

注意，结果表有13列(1个部门id列 + 12个月份的收入列)。</br>

Create table If Not Exists Department (id int, revenue int, month varchar(5))</br>
Truncate table Department</br>
insert into Department (id, revenue, month) values ('1', '8000', 'Jan')</br>
insert into Department (id, revenue, month) values ('2', '9000', 'Jan')</br>
insert into Department (id, revenue, month) values ('3', '10000', 'Feb')</br>
insert into Department (id, revenue, month) values ('1', '7000', 'Feb')</br>
insert into Department (id, revenue, month) values ('1', '6000', 'Mar')</br>

[Link](https://leetcode-cn.com/problems/reformat-department-table/)