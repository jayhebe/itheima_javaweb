SELECT sex, AVG(math) FROM stu GROUP BY sex;

SELECT sex, AVG(math), COUNT(sex) FROM stu GROUP BY sex;

SELECT sex, AVG(math), COUNT(sex) FROM stu WHERE math >= 70 GROUP BY sex;

SELECT sex, AVG(math), COUNT(sex) amount FROM stu WHERE math >= 70 GROUP BY sex HAVING amount > 2;