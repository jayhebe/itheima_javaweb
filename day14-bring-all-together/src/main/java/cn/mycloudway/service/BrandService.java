package cn.mycloudway.service;

import cn.mycloudway.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();

    int add(Brand brand, boolean commit);
}
