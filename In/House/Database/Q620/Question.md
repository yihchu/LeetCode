<h1>有趣的电影</h1>

某城市开了一家新的电影院，吸引了很多人过来看电影。该电影院特别注意用户体验，专门有个LED显示板做电影推荐，上面公布着影评和相关电影描述。</br>
作为该电影院的信息部主管，您需要编写一个SQL查询，找出所有影片描述为非boring(不无聊)的并且id为奇数的影片，结果请按等级rating排列。</br>

例如，下表cinema:</br>
+---------+-----------+--------------+-----------+</br>
|   id    | movie     |  description |  rating   |</br>
+---------+-----------+--------------+-----------+</br>
|   1     | War       |   great 3D   |   8.9     |</br>
|   2     | Science   |   fiction    |   8.5     |</br>
|   3     | irish     |   boring     |   6.2     |</br>
|   4     | Ice song  |   Fantacy    |   8.6     |</br>
|   5     | House card|   Interesting|   9.1     |</br>
+---------+-----------+--------------+-----------+</br>
对于上面的例子，则正确的输出是为：</br>

+---------+-----------+--------------+-----------+</br>
|   id    | movie     |  description |  rating   |</br>
+---------+-----------+--------------+-----------+</br>
|   5     | House card|   Interesting|   9.1     |</br>
|   1     | War       |   great 3D   |   8.9     |</br>
+---------+-----------+--------------+-----------+</br>

Create table If Not Exists cinema (id int, movie varchar(255), description varchar(255), rating float(2, 1))</br>
Truncate table cinema</br>
insert into cinema (id, movie, description, rating) values ('1', 'War', 'great 3D', '8.9');</br>
insert into cinema (id, movie, description, rating) values ('2', 'Science', 'fiction', '8.5');</br>
insert into cinema (id, movie, description, rating) values ('3', 'irish', 'boring', '6.2');</br>
insert into cinema (id, movie, description, rating) values ('4', 'Ice song', 'Fantacy', '8.6');</br>
insert into cinema (id, movie, description, rating) values ('5', 'House card', 'Interesting', '9.1');</br>

[Link](https://leetcode-cn.com/problems/not-boring-movies/)