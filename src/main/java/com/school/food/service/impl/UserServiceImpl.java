package com.school.food.service.impl;

import com.school.food.domain.User;
import com.school.food.mapper.UserMapper;
import com.school.food.service.UserService;
import com.school.support.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        super(mapper);
        this.userMapper = mapper;
    }
    private UserMapper userMapper;

    @Override
    public User selectByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userMapper.selectOne(user);
    }
}