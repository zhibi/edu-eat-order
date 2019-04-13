package edu.eat.order.controller.admin;

import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.exception.MessageException;
import edu.eat.order.base.exception.TipException;
import edu.eat.order.base.response.JsonResponse;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.BusinessService;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 执笔
 * @date 2019/4/9 17:56
 */
@RequestMapping("admin")
@Controller
public class AdminController extends BaseAdminController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private UserService userService;
    @Autowired
    UserMapper userMapper;

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "admin/index";
    }


    /**
     * 登录页
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password) {
        User user = userService.login(username, password, "admin");
        if (null == user) {
            throw new TipException("用户名或者密码错误", "/admin/login");
        }
        session.setAttribute(SESSION_ADMIN, user);
        return redirect("/admin/", "login");
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(SESSION_ADMIN);
        return redirect("/admin/login", "login");
    }

    /**
     * 修改密码
     *
     * @param password
     * @param pwd
     * @param pwd2
     * @return
     */
    @RequestMapping("modifyPwd")
    @ResponseBody
    public JsonResponse<String> modifyPwd(String password, String pwd, String pwd2) {
        if (!pwd.equals(pwd2)) {
            throw new MessageException("两次密码不一样");
        }
        User user = sessionAdmin();
        user = userMapper.selectByPrimaryKey(user.getId());
        if (!user.getPassword().equalsIgnoreCase(MD5Utils.encrypt(password))) {
            throw new MessageException("原密码不对");
        }
        user.setPassword(MD5Utils.encrypt(pwd));
        userMapper.updateByPrimaryKeySelective(user);
        session.removeAttribute(SESSION_ADMIN);
        return JsonResponse.ok("business");
    }

    /**
     * 个人信息
     *
     * @return
     */
    @RequestMapping("info")
    public String info(Model model) {
        User user = userMapper.selectByPrimaryKey(sessionAdmin().getId());
        model.addAttribute(user);
        return "admin/info";
    }
}
