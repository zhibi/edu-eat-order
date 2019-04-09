package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.response.JsonResponse;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("member")
@Controller
@RequestLogin
public class MemberController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("modifyPwd")
    @ResponseBody
    public JsonResponse<String> modifyPwd(String password, String pwd, String pwd2) {
        if (!pwd.equals(pwd2)) {
            throw new MessageException("两次密码不一样");
        }
        User user = userMapper.selectByPrimaryKey(sessionUser().getId());
        if (!user.getPassword().equals(password)) {
            throw new MessageException("原密码不对");
        }
        user.setPassword(pwd);
        userMapper.updateByPrimaryKeySelective(user);
        session.removeAttribute(SESSION_USER);
        return JsonResponse.ok("");
    }

}
