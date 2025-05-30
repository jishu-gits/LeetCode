# Write your MySQL query statement below
select Visits.customer_id, count(Visits.visit_id) as count_no_trans 
FROM Visits
LEFT join Transactions using(visit_id)
Where Transactions.transaction_id is null 
Group by Visits.customer_id
 