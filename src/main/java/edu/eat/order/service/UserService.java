package edu.eat.order.service;

import edu.eat.order.base.base.service.BaseService;
import edu.eat.order.domain.User;

import java.util.List;
import java.util.Map;


public interface UserService extends BaseService<User> {
    /**
     * 通过手机号查找
     *
     * @param phone
     * @return
     */
    User selectByPhone(String phone);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param role     用户类型
     * @return
     */
    User login(String username, String password, String role);

    /**
     * 统计
     *
     * @param id
     * @return
     */
    List<Map<String, Integer>> count(Integer id);
}