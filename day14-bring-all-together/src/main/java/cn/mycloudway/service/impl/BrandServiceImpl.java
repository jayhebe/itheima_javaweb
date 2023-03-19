package cn.mycloudway.service.impl;

import cn.mycloudway.mapper.BrandMapper;
import cn.mycloudway.pojo.Brand;
import cn.mycloudway.service.BrandService;
import cn.mycloudway.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.selectAll();

        sqlSession.close();

        return brands;
    }

    @Override
    public List<Brand> search(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = brandMapper.search(brand);

        sqlSession.close();

        return brands;
    }

    @Override
    public int add(Brand brand, boolean commit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(commit);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int result = brandMapper.add(brand);

        sqlSession.close();

        return result;
    }
}
