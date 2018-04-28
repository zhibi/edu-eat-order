package com.school.support.exception;

/**
 * Created by 执笔 on 2017/1/14.
 * 自定义异常
 */
public class MessageException extends RuntimeException{

    /**
     * 返回url
     */
    private String backUrl;

    public MessageException(String msg){
        super(msg);
    }

    public MessageException(String msg, String backUrl){
        super(msg);
        this.backUrl = backUrl;
    }

    public String getBackUrl() {
        return backUrl;
    }
}
