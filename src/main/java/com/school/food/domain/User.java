package com.school.food.domain;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.*;



@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PHONE")
    private String phone;

    /**
     * 别名
     */
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    /**
     * 1正常  0 锁定 
     */
    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "ADDTIME")
    private Date addtime;


    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
    * 别名
    */
    public String getUsername(){
        return username;
    }

    /**
    * 别名
    */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * 1正常  0 锁定 
    */
    public Integer getStatus(){
        return status;
    }

    /**
    * 1正常  0 锁定 
    */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddtime(){
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }


}