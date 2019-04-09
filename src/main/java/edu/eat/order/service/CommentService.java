package edu.eat.order.service;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Comment;
import edu.eat.order.model.CommentModel;

/**
 * @author 执笔
 * @date 2019/4/9 22:30
 */
public interface CommentService extends BaseService<Comment> {
    /**
     * 通过条件分页查找
     *
     * @param example
     * @return
     */
    PageInfo<CommentModel> selectModelPage(MybatisCondition example);
}
