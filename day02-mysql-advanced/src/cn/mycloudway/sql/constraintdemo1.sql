DROP TABLE IF EXISTS emp;

CREATE TABLE emp(
    id INT PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(50) NOT NULL UNIQUE,
    joindate DATE NOT NULL,
    salary DOUBLE(7, 2) NOT NULL,
    bonus DOUBLE(7, 2) DEFAULT 0
);

SELECT * FROM emp;

INSERT INTO emp(id, ename, joindate, salary, bonus) VALUES (1, "张三", "1999-11-11", 8800, 5000);

INSERT INTO emp(id, ename, joindate, salary, bonus) VALUES (NULL, "李四", "1999-11-11", 8800, 5000);

INSERT INTO emp(id, ename, joindate, salary, bonus) VALUES (1, "张三", "1999-11-11", 8800, 5000);

INSERT INTO emp(id, ename, joindate, salary, bonus) VALUES (3, "王五", "1999-11-11", 8800, 5000);

INSERT INTO emp(id, ename, joindate, salary, bonus) VALUES (4, "李四", "1999-11-11", 8800, 5000);

INSERT INTO emp(id, ename, joindate, salary) VALUES (4, "赵六", "1999-11-11", 8800);

TRUNCATE TABLE emp;