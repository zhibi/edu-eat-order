package com.school.support.base;


import com.school.food.domain.Business;
import com.school.food.domain.User;

/**
 * Created by 执笔 on 2017/3/4.
 */
public abstract class AdminBaseController extends BaseController {

    protected Business sessionAdmin() {
        return (Business) session.getAttribute(SESSION_ADMIN);
    }

}
