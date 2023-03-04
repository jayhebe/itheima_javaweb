package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(@Param("id") int id);
    int add(Brand brand);

    int update(Brand brand);

    int deleteById(@Param("id") int id);
}
