package school.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import school.domain.User;
import school.mapper.UserMapper;
import school.support.BaseController;
import school.support.util.ParamUtils;
import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping("admin/user")
public class AdminUserController extends BaseController {


    @Autowired
    private UserMapper userMapper;

    /**
     * 用户列表
     *
     * @param user
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(User user, @RequestParam(defaultValue = "1") Integer pageNum, Model model) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("username", "admin");
        if (user.getName() != null) {
            criteria.andLike("name", "%" + user.getName() + "%");
        }
        if (user.getUsername() != null) {
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByExample(example), 5);
        model.addAttribute(pageInfo);
        model.addAttribute("url", request.getRequestURI() + "?" + ParamUtils.params2String(request));
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
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("update")
    public String update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return refresh();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
        return refresh();
    }

}
