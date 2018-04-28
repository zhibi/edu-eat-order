package com.school.support.base;


import com.school.food.domain.User;

/**
 * Created by 执笔 on 2017/3/4.
 */
public abstract class AdminBaseController extends BaseController {

    protected User sessionAdmin() {
        return (User) session.getAttribute(SESSION_ADMIN);
    }

}
