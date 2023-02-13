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
    FROM
        stu;

    SELECT DISTINCT(address) FROM stu;

    SELECT name as "姓名", math as "数学成绩", english as "英语成绩" FROM stu;