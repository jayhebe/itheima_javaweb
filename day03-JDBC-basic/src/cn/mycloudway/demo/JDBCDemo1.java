package cn.mycloudway.demo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("day03-JDBC-basic/prop.properties"));

//        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

//        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM emp";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            StringJoiner sj = new StringJoiner("---");

            int id = resultSet.getInt("id");
            String name = resultSet.getString("ename");
            int jobId = resultSet.getInt("job_id");
            int mgr = resultSet.getInt("mgr");
            Date date = resultSet.getDate("joindate");
            double salary = resultSet.getDouble("salary");
            double bonus = resultSet.getDouble("bonus");
            int deptId = resultSet.getInt("dept_id");

            sj.add(id + "").add(name).add(jobId + "").add(mgr + "").add(date.toString()).add(salary + "").add(bonus + "").add(deptId + "");
            System.out.println(sj);
        }

        statement.close();
        conn.close();
    }
}
