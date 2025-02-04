package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.entity.Dish;
import com.birdy.reggie.mapper.DishMapper;
import com.birdy.reggie.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @author Birdy
 * @date 2025/2/3 17:00
 * @description DishServiceImpl
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
