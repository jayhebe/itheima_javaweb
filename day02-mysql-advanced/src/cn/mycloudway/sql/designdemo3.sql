-- 1. 查询所有员工信息。查询员工编号，员工姓名，工资，职务名称，职务描述
SELECT 
	emp.id,
    emp.ename,
    emp.salary,
    job.jname,
    job.description
FROM
	emp
LEFT JOIN
	job
ON
	emp.job_id = job.id;
    
-- 2. 查询员工编号，员工姓名，工资，职务名称，职务描述，部门名称，部门位置
SELECT
	t.id,
    t.ename,
    t.salary,
    t.jname,
    t.description,
    dept.dname,
    dept.loc
FROM
	(
		SELECT
			emp.id,
			emp.ename,
			emp.salary,
			emp.dept_id,
			job.jname,
			job.description
		FROM
			emp
		LEFT JOIN
			job
		ON
			emp.job_id = job.id
	) t
LEFT JOIN
	dept
ON t.dept_id = dept.id;

SELECT
	emp.id,
    emp.ename,
    emp.salary,
	job.jname,
    job.description,
    dept.dname,
    dept.loc
FROM
	emp
LEFT JOIN
	job
ON
	emp.job_id = job.id
LEFT JOIN
	dept
ON
	emp.dept_id = dept.id;

-- 3. 查询员工姓名，工资，工资等级
SELECT * FROM salarygrade;

SELECT
	emp.ename,
    emp.salary,
    salarygrade.grade
FROM
	emp
LEFT JOIN
	salarygrade
ON
	emp.salary >= salarygrade.losalary
AND
	emp.salary <= salarygrade.hisalary;
    
-- 4. 查询员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
SELECT
	d.ename,
    d.salary,
    s.grade,
    d.jname,
    d.description,
    d.dname,
    d.loc
FROM
	(
		SELECT
			j.ename,
			j.salary,
			j.jname,
			j.description,
			dept.dname,
			dept.loc
		FROM
			(
				SELECT
					emp.ename,
					emp.salary,
					emp.job_id,
					emp.dept_id,
					job.jname,
					job.description
				FROM
					emp
				LEFT JOIN
					job
				ON emp.job_id = job.id
			) j
		LEFT JOIN
			dept
		ON j.dept_id = dept.id
	) d
LEFT JOIN
	salarygrade s
ON
	d.salary >= s.losalary
AND
	d.salary <= s.hisalary
ORDER BY
	s.grade
DESC;

-- 5. 查询出部门编号、部门名称、部门位置、部门人数
SELECT
	dept.id,
    dept.dname,
    dept.loc,
	COUNT(emp.dept_id)
FROM
	emp
LEFT JOIN
	dept
ON
	emp.dept_id = dept.id
GROUP BY
	emp.dept_id;
    
SELECT * FROM emp;
SELECT * FROM dept;