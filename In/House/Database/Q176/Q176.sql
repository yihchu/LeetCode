# Write your MySQL query statement below

select max(e2.Salary) as SecondHighestSalary from Employee e1 left join Employee e2 on e1.Salary > e2.Salary;

# 官方答案用的limit offset