package com.school.support.base;


import com.school.food.domain.Business;
import com.school.food.domain.User;


public abstract class AdminBaseController extends BaseController {

    protected Business sessionAdmin() {
        return (Business) session.getAttribute(SESSION_ADMIN);
    }

}
