package cn.mycloudway.service;

import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.impl.BrandServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestBrandService {
    @Test
    public void testSelectAll() {
        BrandService brandService = new BrandServiceImpl();
        List<Brand> brands = brandService.selectAll();

        assert brands != null && brands.size() > 0;
    }
}
