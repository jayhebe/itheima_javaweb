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

    @Test
    public void testSearch() {
        BrandService brandService = new BrandServiceImpl();
        Brand brand = new Brand("华为", null, null, null, null);
        List<Brand> brands = brandService.search(brand);

        assert brands != null && brands.size() > 0;
    }

    @Test
    public void testAdd() {
        BrandService brandService = new BrandServiceImpl();
        Brand brand = new Brand("test", "test", 10, 1, "test");
        int result = brandService.add(brand, false);

        assert result > 0;
    }

    @Test
    public void testDelete() {
        BrandService brandService = new BrandServiceImpl();
        int result = brandService.delete(58, false);

        assert result == 1;
    }
}
