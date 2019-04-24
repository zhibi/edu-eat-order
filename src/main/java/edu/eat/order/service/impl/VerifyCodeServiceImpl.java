package edu.eat.order.service.impl;


import edu.eat.order.service.VerifyCodeService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import static edu.eat.order.base.context.Constant.VERIFY_CODE;


/**
 * 验证码service
 *
 * @author 执笔
 * @date 2018/12/28 22:28
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {


    @Override
    public void saveCode(HttpServletRequest request, String code, String deviceId) {
        request.getSession().setAttribute(VERIFY_CODE, code);
    }

    @Override
    public String getCode(HttpServletRequest request) {
        Object codeInSession = request.getSession().getAttribute(VERIFY_CODE);
        return codeInSession == null ? "" : codeInSession.toString();
    }

    @Override
    public void removeCode(HttpServletRequest request) {
        request.getSession().removeAttribute(VERIFY_CODE);
    }
}
