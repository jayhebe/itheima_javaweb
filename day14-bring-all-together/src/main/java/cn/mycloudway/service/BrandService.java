package cn.mycloudway.service;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    PageBean<Brand> selectByPage(int start, int size);
    PageBean<Brand> search(Brand brand, int start, int size);
    int add(Brand brand, boolean commit);
    int delete(Integer id, boolean commit);
    int update(Brand brand, boolean commit);
}
