package com.school.food.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.school.food.domain.Category;
import com.school.food.mapper.CategoryMapper;
import com.school.support.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

@Controller
@RequestMapping("admin/category")
public class AdminCategoryController extends BaseController {


    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 列表
     *
     * @param category
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Category category, @RequestParam(defaultValue = "1") Integer pageNum, Model model) {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        if (category.getName() != null) {
            criteria.andLike("name", "%" + category.getName() + "%");
        }
        PageHelper.startPage(pageNum, 10);
        PageInfo<Category> pageInfo = new PageInfo<>(categoryMapper.selectByExample(example), 5);
        setModelAttribute(model,pageInfo);
        //model.addAttribute(pageInfo);
        //model.addAttribute("url", request.getRequestURI() + "?" + ParamUtils.params2String(request));
        return "admin/category/list";
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
        Category category = categoryMapper.selectByPrimaryKey(id);
        model.addAttribute(category);
        return "admin/category/detail";
    }

    /**
     * 修改
     *
     * @param category
     * @return
     */
    @RequestMapping("update")
    public String update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
        return refresh();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
        return refresh();
    }

    @GetMapping("add")
    public String add() {
        return "admin/category/add";
    }

    @PostMapping("add")
    public String add(Category category) {
        categoryMapper.insertSelective(category);
        return "redirect:list";
    }
}
