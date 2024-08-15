SELECT 'project A' AS name, DATEDIFF(month, start_date, finish_date) AS month_count
FROM project
GROUP BY month_count
ORDER BY month_count DESC
LIMIT 1;