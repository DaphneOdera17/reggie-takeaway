package com.birdy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.birdy.reggie.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Birdy
 * @date 2025/2/8 16:51
 * @description ShoppingCartMapper
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
