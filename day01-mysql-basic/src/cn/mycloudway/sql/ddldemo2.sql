USE mysql;
SHOW TABLES;

DESC func;

CREATE TABLE tb_user(
	id INT PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255)
);

ALTER TABLE tb_user CHANGE COLUMN name username VARCHAR(255);

DESC tb_user;

ALTER TABLE tb_user CHANGE COLUMN username username VARCHAR(20);
ALTER TABLE tb_user CHANGE COLUMN password password VARCHAR(32);

CREATE TABLE IF NOT EXISTS student (
    id INT PRIMARY KEY,
    username VARCHAR(10) NOT NULL,
    gender CHAR(1) NOT NULL,
    birthday DATE NOT NULL,
    score DOUBLE(5, 2) NOT NULL,
    email VARCHAR(64) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    status TINYINT NOT NULL
);

DESC student;

SELECT * FROM student;