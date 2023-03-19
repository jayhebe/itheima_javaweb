package cn.mycloudway.service;

import cn.mycloudway.pojo.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    List<Brand> search(Brand brand);
    int add(Brand brand, boolean commit);
}
