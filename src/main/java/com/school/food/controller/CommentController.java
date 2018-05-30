package com.school.food.controller;

import com.school.food.domain.Business;
import com.school.food.domain.Comment;
import com.school.food.mapper.BusinessMapper;
import com.school.food.mapper.CommentMapper;
import com.school.support.annocation.request.LoginInfo;
import com.school.support.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@RequestMapping("comment")
@Controller
@LoginInfo
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
