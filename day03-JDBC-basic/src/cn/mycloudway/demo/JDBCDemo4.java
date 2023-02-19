package cn.mycloudway.demo;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo4 {
    @Test
    public void testDQL() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("./prop.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM account";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "---" + resultSet.getString(2) + "---" + resultSet.getDouble(3));
//            System.out.println(resultSet.getInt("id") + "---" + resultSet.getString("name") + "---" + resultSet.getDouble("money"));
        }

        resultSet.close();
        statement.close();
        conn.close();
    }
}
