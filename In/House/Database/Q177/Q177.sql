
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE OFST INTEGER(30);
    SET OFST = N - 1;

    RETURN (
        # Write your MySQL query statement below.
        select max(Salary) as F
        from (select distinct(Salary) from Employee
        order by Salary desc
        limit 1 offset OFST) t
        );
END