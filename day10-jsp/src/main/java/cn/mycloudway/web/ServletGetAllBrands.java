package cn.mycloudway.web;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getAllBrands")
public class ServletGetAllBrands extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandService brandService = new BrandService();
        List<Brand> brands = brandService.selectAll();
        req.setAttribute("brands", brands);

        req.getRequestDispatcher("/getAllBrands.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
