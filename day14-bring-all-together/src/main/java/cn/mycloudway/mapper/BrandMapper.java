package cn.mycloudway.mapper;

import cn.mycloudway.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    List<Brand> search(Brand brand);
    int add(Brand brand);
}
