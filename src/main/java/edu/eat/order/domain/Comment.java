package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "Comment")
public class Comment extends BasePageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer businessId;
    @Column(columnDefinition = "text")
    private String content;
    private Date addtime;
    /**
     * 标签
     */
    private String flag;

    /**
     * 打分
     */
    private Integer start;

    /**
     * 就餐建议
     */
    private String diningAdvice;
    
    /**
     * 服务
     */
    private String serve;

    /**
     * 环境
     */
    private String environment;

    /**
     * 味道
     */
    private String taste;

}
