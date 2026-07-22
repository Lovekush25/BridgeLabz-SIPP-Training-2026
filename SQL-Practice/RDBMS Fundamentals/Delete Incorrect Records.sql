DELETE FROM covid_cases
WHERE country = 'IN';
DELETE FROM covid_cases
WHERE country = 'India'
AND report_date = '2024-01-01'
LIMIT 1;
SELECT * FROM covid_cases;