package edu.eat.order.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.StringUtil;
import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 执笔
 * @date 2019/4/9 18:09
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController extends BaseAdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户列表
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, User user) {
        MybatisCondition example = new MybatisCondition()
                .like("username", user.getUsername())
                .page(user);
        PageInfo<User> pageInfo = userService.selectPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/user/list";
    }

    /**
     * 用户详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        User user = userMapper.selectByPrimaryKey(id);
        model.addAttribute(user);
        return "admin/user/detail";
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @RequestMapping("update")
    public String update(User user) {
        if (StringUtil.isEmpty(user.getPassword())) {
            user.setPassword(null);
        } else {
            user.setPassword(MD5Utils.encrypt(user.getPassword()));
        }
        userMapper.updateByPrimaryKeySelective(user);
        return redirect("detail/" + user.getId());
    }
}
