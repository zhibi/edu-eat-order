package edu.eat.order.controller;

import edu.eat.order.base.annocation.RequestLogin;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("user")
@Controller
@RequestLogin
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper  userMapper;

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

    /**
     * 修改密码
     *
     * @return
     */
    @GetMapping("modifyPwd")
    public String modifyPwd() {
        return "user/modify-pwd";
    }

    /**
     * 修改密码
     *
     * @param pwd
     * @param pwd2
     * @param pwd3
     * @return
     */
    @PostMapping("modifyPwd")
    @RequestLogin
    public String modifyPwd(String pwd, String pwd2, String pwd3) {
        if (!pwd2.equals(pwd3)) {
            return redirect("两次密码不一样", "/user/modifyPwd");
        }
        User user = sessionUser();
        if (!user.getPassword().equalsIgnoreCase(MD5Utils.encrypt(pwd))) {
            return redirect("原密码错误", "/user/modifyPwd");
        }
        user.setPassword(MD5Utils.encrypt(pwd2));
        userMapper.updateByPrimaryKeySelective(user);
        return redirect("修改成功", "/logout");
    }
}
