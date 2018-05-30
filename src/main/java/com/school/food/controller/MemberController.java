package com.school.food.controller;

import com.school.food.domain.User;
import com.school.food.service.UserService;
import com.school.support.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.school.support.annocation.request.LoginInfo;
import com.school.support.exception.MessageException;
import com.school.support.response.Response;


@RequestMapping("member")
@Controller
@LoginInfo(true)
public class MemberController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("modifyPwd")
    @ResponseBody
    public Response<String> modifyPwd(String password, String pwd, String pwd2) {
        if (!pwd.equals(pwd2)) {
            throw new MessageException("两次密码不一样");
        }
        User user = userService.selectByPK(sessionUser().getId());
        if(!user.getPassword().equals(password)){
            throw new MessageException("原密码不对");
        }
        user.setPassword(pwd);
        userService.updateByPKSelective(user);
        session.removeAttribute(SESSION_USER);
        return Response.ok("");
    }

}
