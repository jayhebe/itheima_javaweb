SHOW TABLES;

DROP TABLE tb_user;

DROP TABLE IF EXISTS tb_user;

ALTER TABLE student RENAME TO stu;

ALTER TABLE stu ADD address VARCHAR(255);

DESC stu;

ALTER TABLE stu MODIFY address CHAR(50);

ALTER TABLE stu CHANGE address addr VARCHAR(30);

ALTER TABLE stu DROP addr;