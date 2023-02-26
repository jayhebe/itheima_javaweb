package cn.mycloudway.web.register;

import cn.mycloudway.mapper.UserMapper;
import cn.mycloudway.pojo.User;
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
import java.io.PrintStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);

        resp.setContentType("text/html;charset=utf8");
        PrintWriter writer = resp.getWriter();

        int count = mapper.add(user);
        if (count > 0) {
            writer.write("Register successful.");
        } else {
            writer.write("Register failed.");
        }
    }
}
