package cn.mycloudway.web.servlet;

import cn.mycloudway.util.CheckCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/checkCode")
public class ServletCheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
        String checkCode = CheckCodeUtils.outputVerifyImage(100, 50, outputStream, 4);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("checkCode", checkCode);
    }
}
