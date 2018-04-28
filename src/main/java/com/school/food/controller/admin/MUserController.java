package com.school.food.controller.admin;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.User;
import com.school.food.service.UserService;
import com.school.support.StringUtil;
import com.school.support.base.AdminBaseController;
import com.school.support.base.Page;
import com.school.support.example.Example;
import com.school.support.example.ExampleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class MUserController extends AdminBaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public String list(Model model, Page page, User user) {
        Example example = Example.getInstance()
                .addParam("username", user.getUsername(), ExampleType.Operation.LIKE);
        PageInfo<User> pageInfo = userService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "admin/user/list";
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        User user = userService.selectByPK(id);
        model.addAttribute(user);
        return "admin/user/detail";
    }

    @RequestMapping("update")
    public String update(User user) {
        if(StringUtil.isEmpty(user.getPassword())) user.setPassword(null);
        userService.updateByPKSelective(user);
        return redirect("detail/" + user.getId());
    }
}
