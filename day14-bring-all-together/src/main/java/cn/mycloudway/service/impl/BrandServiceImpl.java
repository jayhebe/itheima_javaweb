package cn.mycloudway.service.impl;

import cn.mycloudway.mapper.BrandMapper;
import cn.mycloudway.pojo.Brand;
import cn.mycloudway.pojo.PageBean;
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

    public PageBean<Brand> selectByPage(int start, int size) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int totalCount = brandMapper.getTotalCount();
        List<Brand> brands = brandMapper.selectByPage(start, size);

        PageBean<Brand> brandPageBean = new PageBean<>(totalCount, brands);

        sqlSession.close();

        return brandPageBean;
    }

    @Override
    public PageBean<Brand> search(Brand brand, int start, int size) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int totalCount = brandMapper.getTotalCountByCondition(brand);
        List<Brand> brands = brandMapper.search(brand, start, size);

        PageBean<Brand> brandPageBean = new PageBean<>(totalCount, brands);

        sqlSession.close();

        return brandPageBean;
    }

    @Override
    public int add(Brand brand, boolean commit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(commit);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int result = brandMapper.add(brand);

        sqlSession.close();

        return result;
    }

    @Override
    public int update(Brand brand, boolean commit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(commit);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int result = brandMapper.update(brand);

        sqlSession.close();

        return result;
    }

    @Override
    public int delete(Integer id, boolean commit) {
        SqlSession sqlSession = sqlSessionFactory.openSession(commit);
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        int result = brandMapper.delete(id);

        sqlSession.close();

        return result;
    }
}
