DROP TABLE IF EXISTS emp;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS dept;

# 创建部门表
CREATE TABLE
    dept(
        did INT PRIMARY KEY AUTO_INCREMENT,
        dname VARCHAR(20)
    );

# 创建员工表
CREATE TABLE
    emp (
        id INT PRIMARY KEY AUTO_INCREMENT,
        NAME VARCHAR(10),
        gender CHAR(1),
        -- 性别
        salary DOUBLE,
        -- 工资
        join_date DATE,
        -- 入职日期
        dep_id INT,
        FOREIGN KEY (dep_id) REFERENCES dept(did) -- 外键，关联部门表(部门表的主键)
    );

-- 添加部门数据

INSERT INTO dept (dNAME) VALUES ('研发部'),('市场部'),('财务部'),('销售部');

-- 添加员工数据

INSERT INTO emp(NAME,gender,salary,join_date,dep_id) VALUES
	('孙悟空','男',7200,'2013-02-24',1),
	('猪八戒','男',3600,'2010-12-02',2),
	('唐僧','男',9000,'2008-08-08',2),
	('白骨精','女',5000,'2015-10-07',3),
	('蜘蛛精','女',4500,'2011-03-14',1),
	('小白龙','男',2500,'2011-02-14',null);

SELECT * FROM emp;

SELECT * FROM dept;

SELECT * FROM emp LEFT JOIN dept ON emp.dep_id = dept.did;