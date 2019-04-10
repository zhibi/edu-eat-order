package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.Comment;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 执笔
 * @date 2019/4/10 18:23
 */
@RequestMapping("comment")
@Controller
@RequestLogin
public class CommentController extends BaseController {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BusinessMapper businessMapper;

    @RequestMapping("send")
    public String send(Comment comment) {
        comment.setAddtime(new Date());
        comment.setUserId(sessionUser().getId());
        commentMapper.insertSelective(comment);
        Business business = businessMapper.selectByPrimaryKey(comment.getBusinessId());
       // business.setComment(business.getComment() + 1);
        businessMapper.updateByPrimaryKeySelective(business);
        return refresh();
    }

    /**
     * 商户的评论
     * @param businessId
     * @param model
     * @return
     */
    @RequestMapping("{businessId}")
    public String comment(@PathVariable Integer businessId, Model model) {
        Business business = businessMapper.selectByPrimaryKey(businessId);
        model.addAttribute(business);
        MybatisCondition example = new MybatisCondition().eq("business_id", businessId).order("id", false);
        List<CommentModel> commentList = commentMapper.selectModel(example);
        model.addAttribute("commentList", commentList);
        return "business/comment-list";
    }
}
