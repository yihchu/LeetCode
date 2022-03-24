<h1>换座位</h1>

小美是一所中学的信息科技老师，她有一张seat座位表，平时用来储存学生名字和与他们相对应的座位id。</br>
其中纵列的id是连续递增的</br>
小美想改变相邻俩学生的座位。</br>
你能不能帮她写一个SQL query来输出小美想要的结果呢？</br>

示例：</br>
+---------+---------+</br>
|    id   | student |</br>
+---------+---------+</br>
|    1    | Abbot   |</br>
|    2    | Doris   |</br>
|    3    | Emerson |</br>
|    4    | Green   |</br>
|    5    | Jeames  |</br>
+---------+---------+</br>

假如数据输入的是上表，则输出结果如下：</br>
+---------+---------+</br>
|    id   | student |</br>
+---------+---------+</br>
|    1    | Doris   |</br>
|    2    | Abbot   |</br>
|    3    | Green   |</br>
|    4    | Emerson |</br>
|    5    | Jeames  |</br>
+---------+---------+</br>
注意：</br>
如果学生人数是奇数，则不需要改变最后一个同学的座位。</br>

Create table If Not Exists Seat (id int, student varchar(255))</br>
Truncate table Seat</br>
insert into Seat (id, student) values ('1', 'Abbot');</br>
insert into Seat (id, student) values ('2', 'Doris');</br>
insert into Seat (id, student) values ('3', 'Emerson');</br>
insert into Seat (id, student) values ('4', 'Green');</br>
insert into Seat (id, student) values ('5', 'Jeames');</br>

[Link](https://leetcode-cn.com/problems/exchange-seats/)