package com.school.food.service;

import com.school.food.domain.User;
import com.school.support.service.BaseService;


public interface UserService extends BaseService<User> {

    User selectByPhone(String phone);
}