package edu.eat.order.model;

import edu.eat.order.domain.Order;
import lombok.Data;

import java.util.List;

/**
 *
 * @author 执笔
 * @date 2019/4/10 13:18
 */
@Data
public class OrderModel extends Order {

    private String userName;
    /**
     *
     */
    private String businessName;

}
