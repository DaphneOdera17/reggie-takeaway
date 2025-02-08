package com.birdy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.birdy.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Birdy
 * @date 2025/2/8 20:05
 * @description OrderMapper
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
