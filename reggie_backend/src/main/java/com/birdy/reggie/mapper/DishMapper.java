package com.birdy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.birdy.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Birdy
 * @date 2025/2/3 16:59
 * @description DishMapper
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
