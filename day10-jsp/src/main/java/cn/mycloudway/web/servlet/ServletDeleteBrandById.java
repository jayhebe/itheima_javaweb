package cn.mycloudway.web.servlet;


import cn.mycloudway.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteBrandById")
public class ServletDeleteBrandById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        BrandService brandService = new BrandService();
        int result = brandService.deleteById(id);

        if (result > 0) {
            resp.sendRedirect("/day10-jsp-1.0-SNAPSHOT/getAllBrands");
        } else {
            resp.setContentType("text/html;charset=utf8");
            PrintWriter writer = resp.getWriter();
            writer.write("删除失败");
        }
    }
}
