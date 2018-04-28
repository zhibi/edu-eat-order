package com.school.food.service;

import com.school.food.domain.User;
import com.school.support.service.BaseService;

/**
* The class create by 执笔 on generate.
*/
public interface UserService extends BaseService<User> {

    User selectByPhone(String phone);
}