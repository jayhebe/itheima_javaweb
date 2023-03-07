package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updateBrand")
public class ServletUpdateBrand extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        int id = Integer.parseInt(req.getParameter("id"));
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        int ordered = Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        int status = Integer.parseInt(req.getParameter("status"));

        Brand brand = new Brand(id, brandName, companyName, ordered, description, status);
        BrandService brandService = new BrandService();
        int result = brandService.update(brand);

        if (result > 0) {
            resp.sendRedirect("/day10-jsp-1.0-SNAPSHOT/getAllBrands");
        } else {
            resp.setContentType("text/html;charset=utf8");
            PrintWriter writer = resp.getWriter();
            writer.write("修改失败");
        }
    }
}
