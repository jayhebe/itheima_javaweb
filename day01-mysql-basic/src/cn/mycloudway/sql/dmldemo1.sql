DESC stu;

SELECT * FROM stu;

INSERT INTO stu
VALUES (
        1,
        "张三",
        "男",
        "2000-01-01",
        180.2,
        "zhangsan@email.com",
        "13812345678",
        1
    );

UPDATE stu SET gender = "男" WHERE username = birthday"张三";

DELETE FROM stu WHERE username = "张三";