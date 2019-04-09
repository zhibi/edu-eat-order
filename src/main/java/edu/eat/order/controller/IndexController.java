package edu.eat.order.controller;

import com.github.pagehelper.PageInfo;
import edu.eat.order.domain.*;
import edu.eat.order.mapper.CategoryMapper;
import edu.eat.order.mapper.CommentMapper;
import edu.eat.order.model.FoodModel;
import edu.eat.order.service.BusinessService;
import edu.eat.order.service.FoodService;
import edu.eat.order.service.UserService;
import edu.eat.order.base.base.controller.BaseController;
import edu.eat.order.base.base.Page;
import edu.eat.order.base.example.Example;
import edu.eat.order.base.example.ExampleType;
import edu.eat.order.base.exception.MessageException;
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

    @RequestMapping({"/", "index"})
    public String index(Model model, @RequestParam(defaultValue = "") String name, String category) {
        Example example = Example.getInstance()
                .addOrder("sort", ExampleType.OrderType.DESC);
        example.addParam("f.status", 1);
        example.addParam("(f.name like '%" + name + "%' or b.name like '%" + name + "%')");
        example.addParam("f.category", category);
        PageInfo<FoodModel> pageInfo = foodService.selectModel(example, new Page(40));
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
        user.setStatus(1);
        userService.insertSelective(user);
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
        Business business = businessService.selectByPK(id);
        model.addAttribute(business);

        Example example = Example.getInstance()
                .addOrder("sort", ExampleType.OrderType.DESC);
        example.addParam("businessid", id);
        example.addParam("status", 1);
        List<Food> foodList = foodService.selectByExample(example);

        model.addAttribute("foodList", foodList);
        return "business";
    }

    @RequestMapping("comment/{id}")
    public String comment(@PathVariable Integer id, Model model) {
        Business business = businessService.selectByPK(id);
        model.addAttribute(business);

        Example example = Example.getInstance().addParam("businessid", id).addOrder("addtime", ExampleType.OrderType.DESC);

        List<Comment> commentList = commentMapper.selectByExample(example);

        model.addAttribute("commentList", commentList);
        return "business-comment";
    }
}