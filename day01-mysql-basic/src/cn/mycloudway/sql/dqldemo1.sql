SELECT * FROM stu;

SELECT name, age FROM stu;

SELECT
    id,
    name,
    age,
    sex,
    address,
    math,
    english,
    hire_date
FROM stu;

SELECT DISTINCT(address) FROM stu;

SELECT name as "姓名", math as "数学成绩", english as "英语成绩" FROM stu;

SELECT * FROM stu WHERE age > 20;

SELECT * FROM stu WHERE age >= 20;

SELECT * FROM stu WHERE age >= 20 AND age <= 30;

SELECT * FROM stu WHERE age BETWEEN 20 AND 30;

SELECT *
FROM stu
WHERE
    hire_date >= "1998-09-01"
    AND hire_date <= "1999-09-01";

SELECT *
FROM stu
WHERE
    hire_date BETWEEN "1998-09-01" AND "1999-09-01";

SELECT * FROM stu WHERE age = 18;

SELECT * FROM stu WHERE age != 18;

SELECT * FROM stu WHERE age <> 18;

SELECT * FROM stu WHERE age = 18 OR age = 20 OR age = 22;

SELECT * FROM stu WHERE age in (18, 20, 22);

SELECT * FROM stu WHERE english IS NULL;

SELECT * FROM stu WHERE name LIKE "马%";

SELECT * FROM stu WHERE name LIKE "_花%";

SELECT * FROM stu WHERE name LIKE "%德%";