package cn.mycloudway.web.register;

import cn.mycloudway.mapper.UserMapper;
import cn.mycloudway.pojo.User;
import cn.mycloudway.util.SqlSessionFactoryUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html;charset=utf8");
        PrintWriter writer = resp.getWriter();

        User user = mapper.selectByUsername(username);
        if (user == null) {
            user = new User(username, password);
            int count = mapper.add(user);
            if (count > 0) {
                writer.write("Register successful.");
            } else {
                writer.write("Register failed.");
            }
        } else {
            writer.write("User already exists.");
        }

        sqlSession.close();
    }
}
