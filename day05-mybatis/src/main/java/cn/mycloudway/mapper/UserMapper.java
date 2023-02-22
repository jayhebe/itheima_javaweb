package cn.mycloudway.mapper;

import cn.mycloudway.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
