# Write your MySQL query statement below
select Today.id 
from Weather as Today
inner join Weather as Yesterday
On DATE_SUB(Today.recordDate, interval 1 day)= Yesterday.recordDate
where Today.temperature > Yesterday.temperature;