package edu.eat.order.mapper;

import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Comment;
import edu.eat.order.model.CommentModel;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 * @author 执笔
 * @date 2019/4/9 22:34
 */
public interface CommentMapper extends Mapper<Comment> {

    /**
     *  查找评论
     * @param example
     * @return
     */
    List<CommentModel> selectModel(MybatisCondition example);
}
