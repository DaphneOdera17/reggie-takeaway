package com.birdy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.birdy.reggie.dto.DishDto;
import com.birdy.reggie.entity.Dish;

/**
 * @author Birdy
 * @date 2025/2/3 17:00
 * @description DishService
 */
public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
