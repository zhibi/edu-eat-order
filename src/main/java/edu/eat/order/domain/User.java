package edu.eat.order.domain;

import edu.eat.order.base.base.dto.BasePageDTO;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @author 执笔
 */
@Table(name = "user")
@Data
public class User extends BasePageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;

    private String username;

    /**
     * 昵称
     */
    private String name;

    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String wx;


    /**
     * SUCCESS
     */
    private String status;

    private Date addtime;

    /**
     * admin user
     */
    private String role;


}