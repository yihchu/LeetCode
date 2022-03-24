
# Write your MySQL query statement below

select c.Name as Customers from Orders o right join Customers c on o.CustomerId = c.Id where o.CustomerId is null;
