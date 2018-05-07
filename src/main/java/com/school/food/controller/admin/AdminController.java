package com.school.food.controller.admin;

import com.school.food.domain.Business;
import com.school.food.domain.User;
import com.school.food.service.BusinessService;
import com.school.food.service.UserService;
import com.school.support.base.AdminBaseController;
import com.school.support.exception.MessageException;
import com.school.support.exception.TipException;
import com.school.support.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 执笔 on 2017/3/16.
 */
@RequestMapping("admin")
@Controller
public class AdminController extends AdminBaseController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping
    public String index() {
        return "admin/index";
    }


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password) {
        Business user = new Business();
        user.setUsername(username);
        user.setPassword(password);
        user = businessService.selectOne(user);
        if (null == user) {
            throw new TipException("用户名或者密码错误", "/admin/login");
        }
        session.setAttribute(SESSION_ADMIN, user);
        return redirect("/admin/");
    }

    @RequestMapping("logout")
    public String logout() {
        session.removeAttribute(SESSION_ADMIN);
        return redirect("/");
    }

    /**
     * 修改密码
     * @param password
     * @param pwd
     * @param pwd2
     * @return
     */
    @RequestMapping("modifyPwd")
    @ResponseBody
    public Response<String> modifyPwd(String password, String pwd, String pwd2) {
        if (!pwd.equals(pwd2)) {
            throw new MessageException("两次密码不一样");
        }
        Business business = sessionAdmin();
        business = businessService.selectByPK(business.getId());
        if (!business.getPassword().equalsIgnoreCase(password)) {
            throw new MessageException("原密码不对");
        }
        business.setPassword(pwd);
        businessService.updateByPKSelective(business);
        session.removeAttribute(SESSION_ADMIN);
        return Response.ok("business");
    }

    /**
     * 商家个人信息
     * @return
     */
    @RequestMapping("info")
    public String info(Model model){
        Business business = businessService.selectByPK(sessionAdmin().getId());
        model.addAttribute(business);
        return "admin/info";
    }
}
