package edu.eat.order.service.impl;

import edu.eat.order.domain.Business;
import edu.eat.order.mapper.BusinessMapper;
import edu.eat.order.service.BusinessService;
import edu.eat.order.base.base.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class BusinessServiceImpl extends BaseServiceImpl<BusinessMapper,Business> implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;
}