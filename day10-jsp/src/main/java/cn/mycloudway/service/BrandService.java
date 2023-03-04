package cn.mycloudway.service;

import cn.mycloudway.mapper.BrandMapper;
import cn.mycloudway.pojo.Brand;
import cn.mycloudway.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();

        return brands;
    }

    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        sqlSession.close();

        return brand;
    }

    public int add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int result = brandMapper.add(brand);

        sqlSession.close();

        return result;
    }

    public int update(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int result = brandMapper.update(brand);

        sqlSession.close();

        return result;
    }
}
