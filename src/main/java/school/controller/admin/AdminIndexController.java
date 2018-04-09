package school.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import school.domain.User;
import school.mapper.UserMapper;
import school.service.UserService;
import school.support.BaseController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminIndexController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping({"index", "/"})
    public String index() {
        return "admin/index";
    }


    /**
     * 到登录页面
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("login")
    public String login(String username, String password, String code) {
        if (!code.equalsIgnoreCase((String) session.getAttribute("verifyCode"))) {
            request.setAttribute("msg", "验证码错误");
            return "admin/login";
        }
        User user = userService.login(username, password);
        if (null == user) {
            request.setAttribute("msg", "用户名或者密码错误");
            return "admin/login";
        }
        session.setAttribute("sessionAdmin", user);
        if ("admin".equals(user.getType())) return "redirect:index";
        return "redirect:index";
    }


    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute("sessionAdmin");
        return "redirect:index";
    }




    /**
     * 修改密码
     *
     * @param pwd
     * @param pwd2
     * @return
     */
    @RequestMapping("modify")
    public String modify(String pwd, String pwd2, HttpSession session, RedirectAttributes model) {
        User user = (User) session.getAttribute("sessionAdmin");
        if (!user.getPassword().equals(pwd)) {
            model.addAttribute("errorMsg", "原密码错误");
            return refresh();
        }
        user.setPassword(pwd2);
        userMapper.updateByPrimaryKeySelective(user);
        session.setAttribute("sessionAdmin", user);
        return "redirect:index";
    }


    /**
     * 更新用户信息
     * 登录用户的信息
     *
     * @param user
     * @return
     */
    @RequestMapping("update")
    public String update(User user) {
        user.setId(sessionUser().getId());
        userMapper.updateByPrimaryKeySelective(user);
        return refresh();
    }
}
