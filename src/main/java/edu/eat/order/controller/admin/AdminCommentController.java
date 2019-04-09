package edu.eat.order.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.Comment;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.model.CommentModel;
import edu.eat.order.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 执笔
 * @date 2019/4/9 18:09
 */
@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController extends BaseAdminController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 评论列表
     *
     * @param model
     * @param comment
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, CommentModel comment) {
        MybatisCondition example = new MybatisCondition()
                .like("u.name", comment.getUserName())
                .like("b.name", comment.getBusinessName())
                .page(comment);
        PageInfo<CommentModel> pageInfo = commentService.selectModelPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/comment/list";
    }

    /**
     * 评论详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        model.addAttribute(comment);
        return "admin/comment/detail";
    }

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        commentMapper.deleteByPrimaryKey(id);
        return prompt("删除成功");
    }
}
