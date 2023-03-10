package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addBrandAxios")
public class ServletAddBrandAxios extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        int ordered = Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        int status = Integer.parseInt(req.getParameter("status"));

        Brand brand = new Brand(brandName, companyName, ordered, description, status);
        BrandService brandService = new BrandService();
        int result = brandService.add(brand);

        resp.getWriter().write("{\"result\":" + result + "}");
    }
}
