package cn.mycloudway.web.login;

import cn.mycloudway.mapper.UserMapper;
import cn.mycloudway.pojo.User;
import cn.mycloudway.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=utf8");

        if (user != null) {
            writer.write("Login successful.");
        } else {
            writer.write("Login failed.");
        }

        sqlSession.close();
    }
}
