package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("user")
@Controller
@RequestLogin
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
     * 个人信息
     *
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {
        User user = userMapper.selectByPrimaryKey(sessionUser().getId());
        model.addAttribute(user);
        return "user/index";
    }

    /**
     * 更新个人信息
     *
     * @param user
     * @return
     */
    @PostMapping("update")
    public String update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return refresh("更新成功");
    }


}
