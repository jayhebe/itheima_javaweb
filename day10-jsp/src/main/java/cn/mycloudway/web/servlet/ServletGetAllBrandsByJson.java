package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getAllBrandsByJson")
public class ServletGetAllBrandsByJson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.selectAll();
        String jsonBrands = JSON.toJSONString(brands);

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(jsonBrands);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
