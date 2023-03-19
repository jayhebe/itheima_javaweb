package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    int add(Brand brand);
}
