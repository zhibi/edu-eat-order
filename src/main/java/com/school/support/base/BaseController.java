package com.school.support.base;

import com.school.food.domain.User;
import com.school.support.ParamUtils;
import com.school.support.context.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


public abstract class BaseController implements Constant {

    @Autowired
    protected HttpSession session;
    @Autowired
    private HttpServletRequest request;

    protected User sessionUser() {
        return (User) session.getAttribute(SESSION_USER);
    }

    /**
     * 保存文件
     *
     * @param file
     * @return
     */
    protected String saveFile(MultipartFile file) {
        String back = file.getOriginalFilename().substring(("." + file.getOriginalFilename()).lastIndexOf("."));
        String fileName = UUID.randomUUID() + "." + back;
        File newFile = new File(request.getServletContext().getRealPath("/data/") + "/" + fileName);
        newFile.getParentFile().mkdirs();
        try {
            newFile.createNewFile();
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传文件: " + newFile.getAbsolutePath());
        return "/data/" + fileName;
    }
    /**
     * 将数据放在model里面
     *
     * @param model
     * @param attributes
     */
    protected void setModelAttribute(Model model, Object... attributes) {
        if (attributes != null && attributes.length > 0) {
            for (Object object : attributes) {
                if (null != object)
                    model.addAttribute(object);
            }
        }
        model.addAttribute("requestUrl", request.getRequestURI() + "?" + ParamUtils.params2String(request));
    }

    /**
     * 刷新页面
     *
     * @return
     * @Date 2016年2月24日 上午11:16:22
     */
    protected String refresh() {
        return "redirect:" + request.getHeader("Referer");
    }

    /**
     * 重定向
     *
     * @param viewName
     * @return
     */
    protected String redirect(String viewName) {
        return "redirect:" + viewName;
    }

}
