package edu.eat.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 执笔
 * @date 2019/4/9 15:22
 */
@SpringBootApplication
@MapperScan("edu.eat.order.mapper")
public class EatOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EatOrderApplication.class, args);
    }
}
