package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;
import cn.mycloudway.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addBrand")
public class ServletAddBrand extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formData = req.getReader().readLine();
        Brand brand = JSON.parseObject(formData, Brand.class);

        BrandService brandService = new BrandServiceImpl();
        int result = brandService.add(brand, true);

        resp.getWriter().write("{\"result\":" + result + "}");
    }
}
