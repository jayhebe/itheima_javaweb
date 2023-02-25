package cn.mycloudway.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet(urlPatterns = "/demo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");
        String[] hobbies = req.getParameterValues("hobby");

        resp.addHeader("Content-type", "text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();
        writer.write("用户名：" + username + "<br>");
        writer.write("密码：" + password + "<br>");
        writer.write("手机号：" + mobile + "<br>");
        writer.write("爱好：");
        for (String hobby : hobbies) {
            writer.write(hobby + " ");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(new String(stringEntry.getKey().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + ": ");
            for (String s : stringEntry.getValue()) {
                System.out.println(new String(s.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + " ");
            }
        }
    }
}
