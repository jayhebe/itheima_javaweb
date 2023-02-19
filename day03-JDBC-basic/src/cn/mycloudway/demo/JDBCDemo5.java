package cn.mycloudway.demo;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo5 {
    @Test
    public void testLogin() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("./prop.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String loginUsername = "zhangsan";
        String loginPassword = "123";

        String sql = "SELECT * FROM tb_user WHERE username = '" + loginUsername + "' AND password = '" + loginPassword + "'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    public void testLoginInjection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("./prop.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String loginUsername = "asdfasdf";
        String loginPassword = "1' or '1' = '1";

        String sql = "SELECT * FROM tb_user WHERE username = '" + loginUsername + "' AND password = '" + loginPassword + "'";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
