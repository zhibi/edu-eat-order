package com.school.food.controller.admin;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.Business;
import com.school.food.service.BusinessService;
import com.school.support.base.AdminBaseController;
import com.school.support.base.Page;
import com.school.support.example.Example;
import com.school.support.example.ExampleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Controller
@RequestMapping("/admin/business")
public class AdminBusinessController extends AdminBaseController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("list")
    public String list(Model model, Page page, Business user) {
        Example example = Example.getInstance()
                .addParam("username", "admin", ExampleType.Operation.NOTEQ)
                .addParam("username", user.getUsername(), ExampleType.Operation.LIKE)
                .addParam("name", user.getName(), ExampleType.Operation.LIKE);
        PageInfo<Business> pageInfo = businessService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "admin/business/list";
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Business business = businessService.selectByPK(id);
        model.addAttribute(business);
        return "admin/business/detail";
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id, Model model) {
        businessService.deleteByPK(id);
        return refresh();
    }

    @RequestMapping("update")
    public String update(Business business, @RequestParam MultipartFile icons) {
        if(business.getPassword() == null || business.getPassword().isEmpty()) business.setPassword(null);
        if (!icons.isEmpty()) {
            business.setIcon(saveFile(icons));
        }
        businessService.updateByPKSelective(business);
        return redirect("detail/" + business.getId());
    }

    /**
     * 到添加页面
     * @return
     */
    @RequestMapping("add")
    public String add(){
        return "admin/business/add";
    }

    /**
     * 添加商家
     * @param business
     * @return
     */
    @RequestMapping("save")
    public String save(Business business, @RequestParam MultipartFile icons) {
        if (!icons.isEmpty()) {
            business.setIcon(saveFile(icons));
        }
        business.setAddtime(new Date());
        businessService.insertSelective(business);
        return redirect("list");
    }
}
