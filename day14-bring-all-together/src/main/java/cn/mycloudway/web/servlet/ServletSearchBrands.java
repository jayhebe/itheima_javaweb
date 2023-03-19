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
import java.util.List;

@WebServlet(urlPatterns = "/searchBrands")
public class ServletSearchBrands extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchData = req.getReader().readLine();
        Brand brand = JSON.parseObject(searchData, Brand.class);
        brand.setBrandName("%" + brand.getBrandName() + "%");
        brand.setCompanyName("%" + brand.getCompanyName() + "%");

        List<Brand> brands = brandService.search(brand);
        String jsonBrands = JSON.toJSONString(brands);

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(jsonBrands);
    }
}
