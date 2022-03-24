# Write your MySQL query statement below

select sub.DNM, emp.Name, emp.Salary
from leetcode.Employee3 emp join
     (SELECT max(e.Salary) as SALR, d.Id as DID, d.Name as DNM FROM leetcode.Employee3 e join leetcode.Department d on e.DepartmentId = d.Id group by d.Id) as sub
     on emp.DepartmentId = sub.DID
where emp.Salary = sub.SALR;
