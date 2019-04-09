package edu.eat.order.base.base.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

/**
 * 分页 基础信息
 *
 * @author 执笔
 */
@Getter
@Setter
public abstract class BasePageDTO {
    @Transient
    private Integer pageNum = 0;
    @Transient
    private Integer pageSize = 10;
}
