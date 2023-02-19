package cn.mycloudway.test;

import cn.mycloudway.pojo.Brand;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    public static Connection getMySQLConnection() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("./druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        return dataSource.getConnection();
    }

    @Test
    public void testDQL() throws Exception {
        Connection conn = getMySQLConnection();
        List<Brand> brandList = new ArrayList<>();

        String sql = "SELECT * FROM tb_brand";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            brandList.add(new Brand(id, brandName, companyName, ordered, description, status));
        }

        System.out.println(brandList);

        resultSet.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void testDMLInsert() throws Exception {
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        Connection conn = getMySQLConnection();

        String sql = "INSERT INTO tb_brand (brand_name, company_name, ordered, description, status) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        int count = pstmt.executeUpdate();
        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }

    @Test
    public void testDMLUpdate() throws Exception {
        String brandName = "拼夕夕";
        String companyName = "拼夕夕";
        int ordered = 2;
        String description = "百万补贴";
        int status = 0;

        Connection conn = getMySQLConnection();

        String sql = "UPDATE tb_brand SET brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, 4);

        int count = pstmt.executeUpdate();
        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }

    @Test
    public void testDMLDelete() throws Exception {
        Connection conn = getMySQLConnection();

        String sql = "DELETE FROM tb_brand WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, 4);
        int count = pstmt.executeUpdate();

        System.out.println(count > 0);

        pstmt.close();
        conn.close();
    }
}
