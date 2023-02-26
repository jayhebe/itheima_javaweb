package cn.mycloudway.mapper;

import cn.mycloudway.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User select(@Param("username") String username, @Param("password") String password);

    int add(User user);
}
