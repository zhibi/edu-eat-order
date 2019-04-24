package edu.eat.order.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 执笔
 * @date 2018/12/28 22:28
 */
public interface VerifyCodeService {
    /**
     * 保存验证码
     *
     * @param request  请求  有session的时候
     * @param code     验证码
     * @param deviceId 设备ID 跨域的时候使用
     */
    void saveCode(HttpServletRequest request, String code, String deviceId);

    /**
     * 获取验证码
     *
     * @param request
     * @return
     */
    String getCode(HttpServletRequest request);

    /**
     * 移除验证码
     *
     * @param request
     */
    void removeCode(HttpServletRequest request);
}
