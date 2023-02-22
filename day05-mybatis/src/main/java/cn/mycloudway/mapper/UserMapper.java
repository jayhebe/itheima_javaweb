package cn.mycloudway.mapper;

import cn.mycloudway.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User selectById(int id);
}
