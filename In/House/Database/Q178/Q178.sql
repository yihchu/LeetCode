# Write your MySQL query statement below

select format(Score, 2), DENSE_RANK() over (order by score desc) `Rank`
from Scores;



# RANK 排名，遇到并列，序号会跳。
# DENSE_RANK 排名，遇到并列，顺序排序。
# ROW_NUMBER 行号。

# format 截断，返回是string类型
# round 四舍五入

