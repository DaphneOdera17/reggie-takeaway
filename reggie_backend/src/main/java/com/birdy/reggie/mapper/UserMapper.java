package com.birdy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.birdy.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Birdy
 * @date 2025/2/7 20:39
 * @description UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
