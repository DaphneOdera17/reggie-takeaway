package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.entity.OrderDetail;
import com.birdy.reggie.mapper.OrderDetailMapper;
import com.birdy.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author Birdy
 * @date 2025/2/8 20:08
 * @description OrderDetailServiceImpl
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
