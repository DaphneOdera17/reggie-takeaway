package com.birdy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.birdy.reggie.dto.SetmealDto;
import com.birdy.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author Birdy
 * @date 2025/2/3 17:00
 * @description SetmealService
 */
public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);
}
