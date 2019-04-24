package edu.eat.order.mapper;

import edu.eat.order.domain.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


public interface UserMapper extends Mapper<User>{

    /**
     * 统计用户预订情况
     * @param id
     * @return
     */
    List<Map<String, Integer>> count(Integer id);
}
