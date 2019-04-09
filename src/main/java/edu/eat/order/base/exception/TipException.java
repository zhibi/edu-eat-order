package edu.eat.order.base.exception;

/**
 * Created by 执笔 on 2017/1/14.
 * 自定义异常
 */
public class TipException extends RuntimeException{

    /**
     * 返回url
     */
    private String backUrl;

    public TipException(String msg){
        super(msg);
    }

    public TipException(String msg, String backUrl){
        super(msg);
        this.backUrl = backUrl;
    }

    public String getBackUrl() {
        return backUrl;
    }
}
