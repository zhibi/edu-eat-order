package edu.eat.order.base.annocation;

import java.lang.annotation.*;

/**
 * 前台需要登录的注解
 * @author 执笔
 * @date 2019/4/2 19:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface RequestLogin {
}
