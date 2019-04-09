package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.Comment;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.base.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


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
        comment.setUserid(sessionUser().getId());
        comment.setUser(sessionUser().getUsername());
        commentMapper.insertSelective(comment);
        Business business = businessMapper.selectByPrimaryKey(comment.getBusinessid());
        business.setComment(business.getComment() + 1);
        businessMapper.updateByPrimaryKeySelective(business);
        return refresh();
    }
}
