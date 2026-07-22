ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);
UPDATE covid_cases
SET vaccination_rate = 78.50
WHERE country = 'India';

DESC covid_cases;