<h1>分数排名</h1>

SQL架构
编写一个SQL查询来实现分数排名。
如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。

+----+-------+</br>
| Id | Score |</br>
+----+-------+</br>
| 1  | 3.50  |</br>
| 2  | 3.65  |</br>
| 3  | 4.00  |</br>
| 4  | 3.85  |</br>
| 5  | 4.00  |</br>
| 6  | 3.65  |</br>
+----+-------+</br>
例如，根据上述给定的Scores表，你的查询应该返回（按分数从高到低排列）：

+-------+------+</br>
| Score | Rank |</br>
+-------+------+</br>
| 4.00  | 1    |</br>
| 4.00  | 1    |</br>
| 3.85  | 2    |</br>
| 3.65  | 3    |</br>
| 3.65  | 3    |</br>
| 3.50  | 4    |</br>
+-------+------+</br>
重要提示：对于MySQL解决方案，如果要转义用作列名的保留字，可以在关键字之前和之后使用撇号。例如 `Rank`

Create table If Not Exists Scores (id int, score DECIMAL(3,2))</br>
Truncate table Scores</br>
insert into Scores (id, score) values ('1', '3.5')</br>
insert into Scores (id, score) values ('2', '3.65')</br>
insert into Scores (id, score) values ('3', '4.0')</br>
insert into Scores (id, score) values ('4', '3.85')</br>
insert into Scores (id, score) values ('5', '4.0')</br>
insert into Scores (id, score) values ('6', '3.65')</br>

[Link](https://leetcode-cn.com/problems/rank-scores/)