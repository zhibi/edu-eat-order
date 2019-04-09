package edu.eat.order.service.impl;

import edu.eat.order.base.base.service.BaseServiceImpl;
import edu.eat.order.base.utils.MD5Utils;
import edu.eat.order.domain.User;
import edu.eat.order.mapper.UserMapper;
import edu.eat.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 执笔
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        return userMapper.selectOne(user);
    }

    @Override
    public User login(String username, String password, String role) {
        User user = new User();
        user.setRole(role);
        user.setUsername(username);
        user.setPassword(MD5Utils.encrypt(password));
        return userMapper.selectOne(user);
    }
}