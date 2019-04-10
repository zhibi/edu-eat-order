package edu.eat.order.controller.admin;

import com.github.pagehelper.PageInfo;
import edu.eat.order.base.base.controller.BaseAdminController;
import edu.eat.order.base.mybatis.condition.MybatisCondition;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.base.utils.StringUtils;
import edu.eat.order.domain.Business;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.BusinessService;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 执笔
 * @date 2019/4/9 18:09
 */
@Controller
@RequestMapping("/admin/business")
public class AdminBusinessController extends BaseAdminController {

    @Autowired
    private BusinessService businessService;

    /**
     * 用户列表
     *
     * @param model
     * @param business
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, Business  business) {
        MybatisCondition example = new MybatisCondition()
                .like("name", business.getName())
                .page(business);
        PageInfo<Business> pageInfo = businessService.selectPage(example);
        setModelAttribute(model, pageInfo);
        return "admin/business/list";
    }
}
