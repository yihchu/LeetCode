# Write your MySQL query statement below

SELECT e1.Name as Employee FROM Employee e1 join Employee e2 on e1.ManagerId = e2.Id where e1.Salary > e2.Salary;
