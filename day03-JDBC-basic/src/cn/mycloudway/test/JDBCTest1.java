package cn.mycloudway.test;

import cn.mycloudway.pojo.Account;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class JDBCTest1 {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileReader("day03-JDBC-basic/prop.properties"));
        ArrayList<Account> accountList = new ArrayList<>();

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM account";

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double money = resultSet.getDouble("money");

            accountList.add(new Account(id, name, money));
        }

        System.out.println(accountList);

        resultSet.close();
        statement.close();
        conn.close();
    }
}
