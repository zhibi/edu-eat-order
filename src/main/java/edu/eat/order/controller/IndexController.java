package edu.eat.order.controller;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.Comment;
import edu.eat.order.domain.Food;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.mapper.FoodMapper;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.model.FoodModel;
import edu.eat.order.service.BusinessService;
import edu.eat.order.service.FoodService;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
     * @param name
     * @return
     */
    @RequestMapping({"/", "index"})
    public String index(Model model, @RequestParam(defaultValue = "") String name) {
        // 展示商家
        MybatisCondition example = new MybatisCondition()
                .order("sort", false)
                .like("name", name)
                .page(1, 16);
        PageInfo<Business> businessPageInfo = businessService.selectPage(example);
        model.addAttribute("businessList", businessPageInfo.getList());
        // 展示菜品
        example = new MybatisCondition()
                .order("f.sort", false)
                .like("f.name", name)
                .page(1, 16);
        PageInfo<FoodModel> foodModelPageInfo = foodService.selectModelPage(example);
        model.addAttribute("foodList", foodModelPageInfo.getList());
        return "index";
    }

    /**
     * @return
     */
    @GetMapping(value = "login")
    public String login() {
        if (null != sessionUser()) {
            throw new MessageException("请先退出当前登录用户");
        }
        return "/login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "/register";
    }


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


    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user) {
        User temp = userService.selectByPhone(user.getPhone());
        if (null != temp) {
            throw new MessageException("该手机号已经注册");
        }
        user.setUsername(user.getPhone());
        user.setAddtime(new Date());
        user.setStatus("success");
        userMapper.insertSelective(user);
        session.setAttribute(SESSION_USER, user);
        return redirect("index");
    }

    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(SESSION_USER);
        return redirect("index");
    }

    /**
     * 详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Business business = businessMapper.selectByPrimaryKey(id);
        model.addAttribute(business);

        MybatisCondition example = new MybatisCondition()
                .order("sort", false).eq("businessid", id)
                .eq("status", 1);
        List<Food> foodList = foodMapper.selectByExample(example);

        model.addAttribute("foodList", foodList);
        return "business";
    }

    @RequestMapping("comment/{id}")
    public String comment(@PathVariable Integer id, Model model) {
        Business business = businessMapper.selectByPrimaryKey(id);
        model.addAttribute(business);

        MybatisCondition example = new MybatisCondition().eq("businessid", id).order("addtime", false);

        List<Comment> commentList = commentMapper.selectByExample(example);

        model.addAttribute("commentList", commentList);
        return "business-comment";
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.encrypt("123456"));
    }
}