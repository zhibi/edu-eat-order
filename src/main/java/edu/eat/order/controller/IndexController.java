package edu.eat.order.controller;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.domain.*;
import edu.eat.order.mapper.*;
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
    private CategoryMapper categoryMapper;
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

    @RequestMapping({"/", "index"})
    public String index(Model model, @RequestParam(defaultValue = "") String name, String category) {
        MybatisCondition example = new MybatisCondition()
                .order("sort", false)
                .eq("f.status", 1)
                .condition("(f.name like '%" + name + "%' or b.name like '%" + name + "%')")
                .eq("f.category", category)
                .page(1, 40);
        PageInfo<FoodModel> pageInfo = foodService.selectModelPage(example);
        model.addAttribute("list", pageInfo.getList());
        List<Category> categoryList = categoryMapper.selectAll();
        session.setAttribute("categoryList", categoryList);
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
}