package edu.eat.order.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

/**
 * UEditor富文本编辑器
 *
 * @author 执笔
 * @date 2019/4/3 16:55
 */
@RequestMapping("ueditor")
@RestController
public class UeditorController {

    /**
     * 服务统一管理
     *
     * @return
     */
    @RequestMapping("server")
    public String server(HttpServletRequest request, @RequestParam(defaultValue = "") String action) throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath();
        String fileUploadPath = path + "/static/";
        String result = new ActionEnter(request, fileUploadPath,"upload").exec();
        //在下面判断如果是列出文件或图片的，替换物理路径的“/” 不然图片管理会有问题
        if ("listfile".equals(action) || "listimage".equals(action)) {
            fileUploadPath = fileUploadPath.replace("\\", "/");
            result = result.replaceAll(fileUploadPath, "/");
        }
        return result;
    }
}
