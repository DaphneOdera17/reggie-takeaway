package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.entity.Employee;
import com.birdy.reggie.mapper.EmployeeMapper;
import com.birdy.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author Birdy
 * @date 2025/1/28 16:20
 * @description EmployeeServiceImpl
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
