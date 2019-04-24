package edu.eat.order.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 执笔
 * @date 2019/4/24 13:51
 */
@Data
@Accessors(chain = true)
public class Start {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private Integer businessId;
}
