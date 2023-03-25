package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.pojo.PageBean;
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

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));

        int start = (page - 1) * pageSize;

        PageBean<Brand> brands = brandService.selectByPage(start, pageSize);
        String jsonBrands = JSON.toJSONString(brands);

        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(jsonBrands);
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchData = req.getReader().readLine();
        Brand brand = JSON.parseObject(searchData, Brand.class);

        int page = Integer.parseInt(req.getParameter("page"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));

        int start = (page - 1) * pageSize;

        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }

        PageBean<Brand> brands = brandService.search(brand, start, pageSize);
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
