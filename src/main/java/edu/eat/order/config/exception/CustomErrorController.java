package edu.eat.order.config.exception;

import edu.eat.order.base.context.Constant;
import edu.eat.order.base.exception.TipException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 全局统一异常处理
 *
 * @author 执笔
 */
@Controller
@Slf4j
public class CustomErrorController extends BasicErrorController {

    private ErrorAttributes errorAttributes;

    public CustomErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
        errorAttributes = new DefaultErrorAttributes();
    }

    @Override
    @RequestMapping(produces = {"text/html"})
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        Throwable error = errorAttributes.getError(new ServletWebRequest(request));
        Map<String, Object> model = this.getErrorAttributes(request, true);
        model.put(Constant.ERROR_MESSAGE, model.get("message"));
        model.put(Constant.BACK_RUL, request.getHeader("Referer"));
        if (error instanceof TipException) {
            model.put(Constant.BACK_RUL, ((TipException) error).getBackUrl());
        }
        log.error("【HTML ERROR】 {}", model);
        return new ModelAndView("error", model);
    }

    @Override
    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = this.getStatus(request);
        log.error("【JSON ERROR】 {}", body);
        return new ResponseEntity(body, status);
    }

}
