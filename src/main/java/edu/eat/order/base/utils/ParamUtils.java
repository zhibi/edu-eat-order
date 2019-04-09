package edu.eat.order.base.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author 执笔
 */
public class ParamUtils {

    /**
     * @param request
     * @return String
     * @Author
     * @Date
     * @Todo 把参数转换为字符串
     */
    public static String params2String(HttpServletRequest request) {
        StringBuffer buffer = new StringBuffer("");
        Enumeration<String> enumeration = request.getParameterNames();
        boolean isFirst = true;
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            if (!"password".equals(key) && !"pageNum".equals(key)) {
                if (isFirst) {
                    buffer.append(key + "=" + request.getParameter(key));
                    isFirst = false;
                } else {
                    buffer.append("&" + key + "=" + request.getParameter(key));
                }
            }
        }
        return buffer.toString();
    }
}
