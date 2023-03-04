package cn.mycloudway.web;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/getBrandById")
public class ServletGetBrandById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        BrandService brandService = new BrandService();
        Brand brand = brandService.selectById(id);

        if (brand != null) {
            req.setAttribute("brand", brand);
            req.getRequestDispatcher("/updateBrand.jsp").forward(req, resp);
        } else {
            resp.setContentType("text/html;charset=utf8");
            PrintWriter writer = resp.getWriter();
            writer.write("该ID不存在");
        }
    }
}
