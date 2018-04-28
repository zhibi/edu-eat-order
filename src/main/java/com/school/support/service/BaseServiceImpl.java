package com.school.support.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.support.base.Page;
import com.school.support.example.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);


    private Mapper<T> mapper;

    public BaseServiceImpl(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    public PageInfo<T> selectAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<T>(mapper.selectAll(), Page.NAV_SIZE);
    }

    public List<T> selectAll() {
        return mapper.selectAll();
    }

    public T selectByPK(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public List<T> select(T entity) {
        return mapper.select(entity);
    }

    public PageInfo<T> select(T entity, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<T>(mapper.select(entity), Page.NAV_SIZE);
    }

    public PageInfo<T> selectByExample(Example example, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<T>(mapper.selectByExample(example), Page.NAV_SIZE);
    }

    public List<T> selectByExample(Example example) {
        return mapper.selectByExample(example);
    }

    public int selectCount(T entity) {
        return mapper.selectCount(entity);
    }

    public int delete(T entity) {
        return mapper.delete(entity);
    }

    public int deleteByPK(Object key) {
        return mapper.deleteByPrimaryKey(key);

    }

    public int deleteByPKs(List<?> ids) {
        int sum = 0;
        for (Object id : ids) {
            sum += mapper.deleteByPrimaryKey(id);
        }
        return sum;
    }

    public int deleteByExample(Example example) {
        return mapper.deleteByExample(example);
    }

    public int updateByPK(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateByExample(T entity, Example example) {
        return mapper.updateByExample(entity, example);
    }

    public int updateByPKSelective(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public int updateByExampleSelective(T entity, Example example) {
        return mapper.updateByExampleSelective(entity, example);
    }

    public int insert(T entity) throws Exception {
        return mapper.insert(entity);
    }

    public int insertBatch(List<T> list) {
        int sum = 0;
        for (T entity : list) {
            sum += mapper.insertSelective(entity);
        }
        return sum;
    }

    public int insertSelective(T entity) {
        return mapper.insertSelective(entity);
    }

    public int selectCountByExample(Example example) {
        return mapper.selectCountByExample(example);
    }
}
