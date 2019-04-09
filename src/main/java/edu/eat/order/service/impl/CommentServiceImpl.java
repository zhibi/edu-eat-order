package edu.eat.order.service.impl;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Comment;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.model.CommentModel;
import edu.eat.order.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 执笔
 * @date 2019/4/9 22:31
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PageInfo<CommentModel> selectModelPage(MybatisCondition example) {
        stratPage(example);
        return new PageInfo<CommentModel>(commentMapper.selectModel(example));
    }
}
