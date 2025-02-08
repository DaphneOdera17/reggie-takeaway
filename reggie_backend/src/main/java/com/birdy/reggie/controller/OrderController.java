package com.birdy.reggie.controller;

import com.birdy.reggie.common.R;
import com.birdy.reggie.entity.Orders;
import com.birdy.reggie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Birdy
 * @date 2025/2/8 20:08
 * @description OrderController
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 提交订单
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        orderService.submit(orders);

        return R.success("下单成功");
    }
}
