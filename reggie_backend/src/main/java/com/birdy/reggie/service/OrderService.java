package com.birdy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.birdy.reggie.entity.Orders;

/**
 * @author Birdy
 * @date 2025/2/8 20:07
 * @description OrderService
 */
public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);
}
