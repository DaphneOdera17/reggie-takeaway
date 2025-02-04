package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.common.CustomException;
import com.birdy.reggie.entity.Category;
import com.birdy.reggie.entity.Dish;
import com.birdy.reggie.entity.Setmeal;
import com.birdy.reggie.mapper.CategoryMapper;
import com.birdy.reggie.service.CategoryService;
import com.birdy.reggie.service.DishService;
import com.birdy.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Birdy
 * @date 2025/2/3 13:45
 * @description CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 删除分类
     * @param id
     */
    @Override
    public void remove(@RequestParam("ids") Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);

        // 查询当前分类是否关联了菜品，如果关联，抛出业务异常
        if(dishService.count(dishLambdaQueryWrapper) > 0) {
            throw new CustomException("当前分类下关联了菜品，不能删除");
        }

        // 查询当前分类是否关联了套餐，如果关联，抛出业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);

        if(setmealService.count(setmealLambdaQueryWrapper) > 0) {
            throw new CustomException("当前分类下关联了套餐，不能删除");
        }

        // 删除分类
        super.removeById(id);
    }
}
