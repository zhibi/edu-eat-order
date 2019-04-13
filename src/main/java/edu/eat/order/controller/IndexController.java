package edu.eat.order.controller;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.BusinessService;
import edu.eat.order.service.FoodService;
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
    private FoodService foodService;
    @Autowired
    private UserService userService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private FoodMapper foodMapper;

    /**
     * 首页展示
     *
     * @param model
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index(Model model) {
        // 展示商家
        MybatisCondition example = new MybatisCondition()
                .order("sort", false)
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
        if (null != sessionUser()) {
            throw new MessageException("请先退出当前登录用户");
        }
        return "/login";
    }

    /**
     * 跳转注册页
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "/register";
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
        User user = userService.selectByPhone(phone);
        if (null == user) {
            throw new MessageException("该用户不存在");
        }
        if (!user.getPassword().equalsIgnoreCase(password)) {
            throw new MessageException("用户名或密码错误");
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
    public String register(User user) {
        User temp = userService.selectByPhone(user.getPhone());
        if (null != temp) {
            throw new MessageException("该手机号已经注册");
        }
        user.setPassword(MD5Utils.encrypt(user.getPassword()));
        user.setUsername(user.getPhone());
        user.setAddtime(new Date());
        user.setStatus("SUCCESS");
        userMapper.insertSelective(user);
        session.setAttribute(SESSION_USER, user);
        return redirect("index");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(SESSION_USER);
        return redirect("index");
    }


}