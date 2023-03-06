package cn.mycloudway.web;

import cn.mycloudway.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        if (!userService.exists(username)) {
            int result = userService.register(username, password);

            if (result > 0) {
                req.setAttribute("register_msg", "注册成功，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("register_msg", "注册失败，请联系管理员");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("register_msg", "用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
