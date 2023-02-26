package cn.mycloudway.web.mapper;

import cn.mycloudway.web.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User select(@Param("username") String username, @Param("password") String password);
}
