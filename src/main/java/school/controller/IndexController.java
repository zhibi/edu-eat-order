package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import school.domain.User;
import school.mapper.UserMapper;
import school.service.UserService;
import school.support.BaseController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping({"/", "index"})
    public String index() {
        return "index";
    }

    /**
     * 到注册页面
     *
     * @return
     */
    @GetMapping("register")
    public String register() {
        return "register";
    }

    /**
     * 注册用户
     *
     * @return
     */
    @PostMapping("register")
    public String register(User user, Model model) {
        if (userService.selectByUsername(user.getUsername()) != null) {
            model.addAttribute("msg", "用户名已经存在");
            return "register";
        }
        if (userService.selectByEmail(user.getEmail()) != null) {
            model.addAttribute("msg", "邮箱已经存在");
            return "register";
        }

        user.setAddtime(new Date());
        user.setDeal(0);
        user.setIllegal(0);
        userMapper.insert(user);
        return "redirect:index";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "login";
    }

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userService.login(username, password);
        if (null == user) {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
        session.setAttribute("sessionUser", user);
        return "redirect:index";
    }

    /**
     * 退出系统
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("sessionUser");
        return "redirect:login";
    }

    @RequestMapping("project/{id}")
    public String project(@PathVariable Integer id){
        return "project";
    }
}
