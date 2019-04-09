package edu.eat.order.base.base.service;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.dto.BasePageDTO;
import edu.eat.order.base.mybatis.condition.MybatisCondition;

/**
 * 基础service
 * @author  执笔
 * @param <T>
 */
public interface BaseService<T extends BasePageDTO> {

    /**
     * 分页
     * @param dto
     * @return
     */
    PageInfo<T> selectPage(T dto);

    /**
     * 分页
     * @param condition
     * @return
     */
    PageInfo<T> selectPage(MybatisCondition condition);

}
