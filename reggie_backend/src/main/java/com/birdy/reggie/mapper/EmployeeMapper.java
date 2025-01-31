package com.birdy.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.birdy.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Birdy
 * @date 2025/1/28 16:19
 * @description EmployeeMapper
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}
