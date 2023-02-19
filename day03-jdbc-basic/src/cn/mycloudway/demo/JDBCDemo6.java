package cn.mycloudway.demo;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo6 {
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

        String sql = "SELECT * FROM tb_user WHERE username = ? AND password = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, loginUsername);
        pstmt.setString(2, loginPassword);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        rs.close();
        pstmt.close();
        conn.close();
    }
}
