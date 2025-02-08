package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.entity.ShoppingCart;
import com.birdy.reggie.mapper.ShoppingCartMapper;
import com.birdy.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author Birdy
 * @date 2025/2/8 16:52
 * @description ShoppingCartServiceImpl
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
