package com.school.food.service.impl;

import com.school.food.domain.Business;
import com.school.food.mapper.BusinessMapper;
import com.school.food.service.BusinessService;
import com.school.support.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements BusinessService {

    @Autowired
    public BusinessServiceImpl(BusinessMapper mapper) {
        super(mapper);
        this.businessMapper = mapper;
    }
    private BusinessMapper businessMapper;
}