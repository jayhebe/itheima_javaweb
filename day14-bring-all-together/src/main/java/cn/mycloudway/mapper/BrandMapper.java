package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    List<Brand> search(Brand brand);
    int add(Brand brand);
    int delete(@Param("id") Integer id);
    int update(Brand brand);
}
