package cn.mycloudway.web.servlet;

import cn.mycloudway.pojo.User;
import cn.mycloudway.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        HttpSession httpSession = req.getSession();
        String correctCheckCode = (String) httpSession.getAttribute("checkCode");

        UserService userService = new UserService();
        if (userService.exists(username)) {
            req.setAttribute("register_msg", "用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!checkCode.equalsIgnoreCase(correctCheckCode)) {
            req.setAttribute("register_msg", "验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        User user = new User(username, password);
        int result = userService.register(user);

        if (result > 0) {
            req.setAttribute("register_msg", "注册成功，请登录");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            req.setAttribute("register_msg", "注册失败，请联系管理员");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
