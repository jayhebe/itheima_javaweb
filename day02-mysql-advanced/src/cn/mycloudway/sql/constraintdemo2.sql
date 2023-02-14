CREATE TABLE
    dept(
        id INT PRIMARY KEY AUTO_INCREMENT,
        dep_name VARCHAR(20),
        addr VARCHAR(20)
    );

CREATE TABLE
    employee(
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(20),
        age INT,
        dep_id INT
    );

INSERT INTO
    dept (dep_name, addr)
VALUES ("研发部", "广州"), ("销售部", "深圳");

SELECT * FROM dept;

INSERT INTO
    employee (name, age, dep_id)
VALUES ("张三", 20, 1), ("李四", 20, 1), ("王五", 20, 1), ("赵六", 20, 2), ("孙七", 22, 2), ("周八", 18, 2);

SELECT * FROM employee;

DROP TABLE IF EXISTS dept;
DROP TABLE IF EXISTS employee;

CREATE TABLE
    dept(
        id INT PRIMARY KEY AUTO_INCREMENT,
        dep_name VARCHAR(20),
        addr VARCHAR(20)
    );

CREATE TABLE
    employee(
        id INT PRIMARY KEY AUTO_INCREMENT,
        name VARCHAR(20),
        age INT,
        dep_id INT,
        CONSTRAINT fk_employee_dept FOREIGN KEY employee(dep_id) REFERENCES dept(id)
    );

DESC employee;

DESC dept;

DELETE FROM dept WHERE id = 1;

TRUNCATE TABLE employee;
TRUNCATE TABLE dept;

ALTER TABLE employee DROP FOREIGN KEY fk_employee_dept;

ALTER TABLE employee ADD CONSTRAINT fk_employee_dept FOREIGN KEY employee(dep_id) REFERENCES dept(id);