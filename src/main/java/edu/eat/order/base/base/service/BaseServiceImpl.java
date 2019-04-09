package edu.eat.order.base.base.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.dto.BasePageDTO;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * 基础service 实现
 *
 * @param <T>
 * @author 执笔
 */
public class BaseServiceImpl<E extends Mapper<T>, T extends BasePageDTO> implements BaseService<T> {

    @Autowired
    protected E mapper;


    @Override
    public PageInfo<T> selectPage(T dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(mapper.select(dto));
    }

    @Override
    public PageInfo<T> selectPage(MybatisCondition condition) {
        PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        return new PageInfo<>(mapper.selectByExample(condition));
    }


}
