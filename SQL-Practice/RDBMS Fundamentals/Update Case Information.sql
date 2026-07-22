UPDATE covid_cases
SET confirmed_cases = 45200000
WHERE country = 'India'
AND report_date = '2024-02-01';
SELECT *
FROM covid_cases
WHERE country = 'India';