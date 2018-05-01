package com.school.food.controller.admin;

import com.github.pagehelper.PageInfo;
import com.school.food.domain.Category;
import com.school.food.domain.Food;
import com.school.food.mapper.CategoryMapper;
import com.school.food.model.FoodModel;
import com.school.food.service.FoodService;
import com.school.support.base.AdminBaseController;
import com.school.support.base.Page;
import com.school.support.example.Example;
import com.school.support.example.ExampleType;
import com.school.support.exception.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by 执笔 on 2017/3/16.
 */
@Controller
@RequestMapping("admin/food")
public class MFoodController extends AdminBaseController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("list")
    public String list(Model model, Page page, FoodModel foodModel) {
        Example example = Example.getInstance()
                .addParam("f.name", foodModel.getName(), ExampleType.Operation.LIKE)
                .addOrder("f.addtime");
        if (!sessionAdmin().getUsername().equals("admin")) {
            example.addParam("f.businessid", sessionAdmin().getId());
        }
        PageInfo<FoodModel> pageInfo = foodService.selectModel(example, page);
        setModelAttribute(model, pageInfo);
        return "admin/food/list";
    }

    @RequestMapping("updateStatus/{id}")
    public String updateStatus(@PathVariable Integer id) {
        Food food = foodService.selectByPK(id);
        if (null == food) {
            throw new MessageException("该餐品不存在");
        }
        food.setStatus((food.getStatus() + 1) % 2);
        foodService.updateByPKSelective(food);
        return refresh();
    }

    @RequestMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Food food = foodService.selectByPK(id);
        if (null == food) {
            throw new MessageException("该餐品不存在");
        }
        model.addAttribute(food);

        List<Category> categoryList = categoryMapper.selectAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/food/detail";
    }

    @RequestMapping("updateFood")
    public String updateFood(Food food, @RequestParam MultipartFile icons) {
        saveFoodImg(food, icons);
        return redirect("detail/" + food.getId());
    }


    @RequestMapping("add")
    public String add(Model model) {
        List<Category> categoryList = categoryMapper.selectAll();
        model.addAttribute("categoryList", categoryList);
        return "admin/food/add";
    }

    @RequestMapping("save")
    public String save(Food food, @RequestParam MultipartFile icons) {
        food.setAddtime(new Date());
        food.setTimes(0);
        food.setBusinessid(sessionAdmin().getId());
        food.setSort(0);
        foodService.insertSelective(food);
        saveFoodImg(food, icons);
        return redirect("detail/" + food.getId());
    }

    private void saveFoodImg(Food food, MultipartFile icons) {

        if (!icons.isEmpty()) {
            food.setIcon(saveFile(icons));
        }
        foodService.updateByPKSelective(food);
    }
}
