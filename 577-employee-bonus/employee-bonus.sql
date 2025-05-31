# Write your MySQL query statement below
select name, bonus 
from Employee 
left join Bonus using(empId)
where ifnull(Bonus.bonus, 0)< 1000;