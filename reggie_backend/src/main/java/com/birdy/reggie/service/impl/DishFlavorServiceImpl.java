package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.entity.DishFlavor;
import com.birdy.reggie.mapper.DishFlavorMapper;
import com.birdy.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author Birdy
 * @date 2025/2/4 19:05
 * @description DishFlavorServiceImpl
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
