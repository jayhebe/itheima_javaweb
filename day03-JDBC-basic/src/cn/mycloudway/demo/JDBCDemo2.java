package cn.mycloudway.demo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDemo2 {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("day03-JDBC-basic/prop.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql1 = "UPDATE account SET money = 1000 WHERE id = 1";
        String sql2 = "UPDATE account SET money = 1000 WHERE id = 2";

        Statement statement = conn.createStatement();

        try {
            conn.setAutoCommit(false);
            int count1 = statement.executeUpdate(sql1);
            System.out.println(count1);
            int count2 = statement.executeUpdate(sql2);
            System.out.println(count2);
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            statement.close();
            conn.close();
        }
    }
}
