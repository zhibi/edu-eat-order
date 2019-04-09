package edu.eat.order.model;

import edu.eat.order.domain.Comment;
import lombok.Data;

/**
 * @author 执笔
 * @date 2019/4/9 22:28
 */
@Data
public class CommentModel extends Comment {

    /**
     * 评论人
     */
    private String userName;


    /**
     * 商家名字
     */
    private String businessName;
}
