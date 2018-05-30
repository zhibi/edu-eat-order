package com.school.food.domain;

import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
 
import java.util.*;



@Table(name="orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ORDERNO")
    private String orderno;

    @Column(name = "ADDTIME")
    private Date addtime;

    /**
     * 总价格
     */
    @Column(name = "TOTAL")
    private Double total;

    /**
     * 1支付
     */
    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "user_id")
    private Integer userId;

    private Date paytime;

    @Column(name = "Receiveuser")
    private String receiveuser;

    @Column(name = "Receiveaddress")
    private String receiveaddress;
    private String phone;

    private Date sendtime;

    private Date receivetime;

    private String ids;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno(){
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Date getAddtime(){
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
    * 总价格
    */
    public Double getTotal(){
        return total;
    }

    /**
    * 总价格
    */
    public void setTotal(Double total) {
        this.total = total;
    }


    public Integer getStatus(){
        return status;
    }


    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark(){
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPaytime(){
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getReceiveuser(){
        return receiveuser;
    }

    public void setReceiveuser(String receiveuser) {
        this.receiveuser = receiveuser;
    }

    public String getReceiveaddress(){
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public Date getSendtime(){
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Date getReceivetime(){
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }


}