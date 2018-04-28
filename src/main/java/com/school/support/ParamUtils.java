package com.school.support;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class ParamUtils {

    /**
     * @Author 执笔
     * @Date 2016年1月7日 下午10:22:06
     * @Todo 把参数转换为字符串
     * @param request
     * @return String
     */
    public static String params2String(HttpServletRequest request){
        StringBuffer buffer = new StringBuffer("");
        Enumeration<String> enumeration = request.getParameterNames();
        boolean isFirst = true;
        while(enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            if(!key.equals("password") && !key.equals("pageNum")){//密码不显示
                if(isFirst){
                    buffer.append(key+"="+request.getParameter(key));
                    isFirst = false;
                }else{
                    buffer.append("&"+key+"="+request.getParameter(key));
                }
            }
        }
        return buffer.toString();
    }
}
