SELECT 'eldest' AS type, name, birthday
FROM worker
WHERE DATEDIFF(day, birthday, now()) > 29000

UNION ALL

SELECT 'youngest' AS type, name, birthday
FROM worker
WHERE DATEDIFF(day, birthday, now()) < 14000;