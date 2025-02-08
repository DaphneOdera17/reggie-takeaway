package com.birdy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.birdy.reggie.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Birdy
 * @date 2025/2/8 20:06
 * @description OrderDetailMapper
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}
