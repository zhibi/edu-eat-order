package com.school.support.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.school.support.base.Page;
import com.school.support.example.Example;

public interface BaseService<T> {

    T selectOne(T entity);

    PageInfo<T> selectAll(Page page);

    List<T> selectAll();

    T selectByPK(Object key);

    List<T> select(T entity);

    PageInfo<T> select(T entity, Page page);

    PageInfo<T> selectByExample(Example example, Page page);

    List<T> selectByExample(Example example);

    int selectCount(T entity);

    int selectCountByExample(Example example);

    int delete(T entity);

    int deleteByPK(Object key);

    int deleteByPKs(List<?> ids);

    int deleteByExample(Example example);

    int updateByPK(T entity);

    int updateByExample(T entity, Example example);

    int updateByPKSelective(T entity);

    int updateByExampleSelective(T entity, Example example);

    int insert(T entity) throws Exception;

    int insertBatch(List<T> list);

    int insertSelective(T entity);
}
