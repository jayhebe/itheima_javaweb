package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;
import cn.mycloudway.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/brand/*")
public class ServletBrand extends ServletBase {
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonBrands = JSON.toJSONString(brands);

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(jsonBrands);
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchData = req.getReader().readLine();
        Brand brand = JSON.parseObject(searchData, Brand.class);
        brand.setBrandName("%" + brand.getBrandName() + "%");
        brand.setCompanyName("%" + brand.getCompanyName() + "%");

        List<Brand> brands = brandService.search(brand);
        String jsonBrands = JSON.toJSONString(brands);

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(jsonBrands);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formData = req.getReader().readLine();
        Brand brand = JSON.parseObject(formData, Brand.class);

        int result = brandService.add(brand, true);

        resp.getWriter().write("{\"result\":" + result + "}");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formData = req.getReader().readLine();
        Brand brand = JSON.parseObject(formData, Brand.class);

        int result = brandService.update(brand, true);

        resp.getWriter().write("{\"result\":" + result + "}");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String item = req.getReader().readLine();
        Brand brand = JSON.parseObject(item, Brand.class);
        int result = brandService.delete(brand.getId(), true);

        resp.getWriter().write("{\"result\":" + result + "}");
    }

    public void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String items = req.getReader().readLine();
        List<Brand> brands = JSON.parseArray(items, Brand.class);
        int result = 0;

        for (Brand brand : brands) {
            result += brandService.delete(brand.getId(), true);
        }

        resp.getWriter().write("{\"result\":" + result + "}");
    }
}
