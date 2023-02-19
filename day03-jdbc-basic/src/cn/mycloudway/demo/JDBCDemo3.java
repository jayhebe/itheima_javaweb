package cn.mycloudway.demo;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCDemo3 {
    @Test
    public void testDML() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("./prop.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE account SET money = 1000 WHERE id = 1";

        Statement statement = conn.createStatement();

        int count = statement.executeUpdate(sql);
        if (count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        statement.close();
        conn.close();
    }

    @Test
    public void testDDL() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("./prop.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "DROP DATABASE IF EXISTS db2";

        Statement statement = conn.createStatement();

        int count = statement.executeUpdate(sql);
        System.out.println(count);

        statement.close();
        conn.close();
    }
}
