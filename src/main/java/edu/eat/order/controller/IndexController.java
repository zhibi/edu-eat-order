package edu.eat.order.controller;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.BusinessService;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * @author 执笔
 * @date 2019/4/13 16:46
 */
@Controller
@RequestMapping
public class IndexController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private UserMapper userMapper;


    /**
     * 首页展示
     *
     * @param model
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index(Model model, String name) {
        // 展示商家
        MybatisCondition example = new MybatisCondition()
                .order("sort", false)
                .like("name", name)
                .page(1, 50);
        PageInfo<Business> businessPageInfo = businessService.selectPage(example);
        model.addAttribute("businessList", businessPageInfo.getList());
        return "index";
    }

    /**
     * 登录
     *
     * @return
     */
    @GetMapping(value = "login")
    public String login() {
        return "login";
    }

    /**
     * 跳转注册页
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }


    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @PostMapping(value = "login")
    public String login(String phone, String password) {
        User user = userService.login(phone, password, "user");
        if (null == user) {
            return redirect("用户名或密码错误", "login");
        }
        session.setAttribute(SESSION_USER, user);
        return redirect("/");
    }


    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user, String password2) {
        if (!user.getPassword().equals(password2)) {
            return redirect("两次密码不一样", "register");
        }
        User temp = userService.selectByPhone(user.getPhone());
        if (null != temp) {
            return redirect("该手机号已经注册", "register");
        }
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setUsername(user.getPhone());
        user.setAddtime(new Date());
        user.setStatus("SUCCESS");
        user.setRole("user");
        userMapper.insertSelective(user);
        return redirect("注册成功，请登录", "login");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(SESSION_USER);
        return redirect("login");
    }


}