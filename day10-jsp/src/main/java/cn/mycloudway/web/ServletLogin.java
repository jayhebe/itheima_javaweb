package cn.mycloudway.web;

import cn.mycloudway.pojo.User;
import cn.mycloudway.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        User user = userService.login(username, password);

        if (user != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            req.getRequestDispatcher("/getAllBrands").forward(req, resp);
        } else {
            req.setAttribute("login_msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
