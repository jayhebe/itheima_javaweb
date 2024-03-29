package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    List<Brand> selectByPage(@Param("start") int start, @Param("size") int size);
    List<Brand> search(@Param("brand") Brand brand, @Param("start") int start, @Param("size") int size);
    int add(Brand brand);
    int delete(@Param("id") Integer id);
    int update(Brand brand);
    int getTotalCount();
    int getTotalCountByCondition(Brand brand);
}
