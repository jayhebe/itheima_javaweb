package cn.mycloudway.service;

import cn.mycloudway.mapper.UserMapper;
import cn.mycloudway.pojo.User;
import cn.mycloudway.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    public User login(String username, String password) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.select(username, password);

        sqlSession.close();

        return user;
    }
}
