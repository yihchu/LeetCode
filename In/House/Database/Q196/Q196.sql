# Write your MySQL query statement below

# 注意看这道题的提示部分，说要是用delete语句，还有执行sql后输出的是整张表
# 刚开始我就没看懂，寻思，不就是一个查询么，干啥要delete？既然是有条件的查询，为啥还说输出整张表，以后出题人好像有点什么大病。
# 然后写了一个sql，怎么看都觉得没问题，然后就提交了，结果应该是两条，但是本地好好地，扔上去就输出三条，我还以为我自己瞎了。
# (select min(Id) Id, Email from Person group by Email)
# 看了看评论，才明白，你妹，一个查询你让我删数据！！
# 然后再看一遍题，哦，原来写的就是"删除Person表中所有重复的电子邮箱"。
# 原来有大病的是自己。

delete p from Person p left join (select min(Id) NID from Person group by Email) as s on p.Id = s.NID where s.NID is null;
