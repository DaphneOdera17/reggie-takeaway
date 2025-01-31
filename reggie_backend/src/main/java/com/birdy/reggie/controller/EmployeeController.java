package com.birdy.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.birdy.reggie.common.R;
import com.birdy.reggie.entity.Employee;
import com.birdy.reggie.service.EmployeeService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Birdy
 * @date 2025/1/28 16:20
 * @description EmployeeController
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        String password = employee.getPassword();
        // md5 算法对密码进行加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        // Employee::getUsername 等价于创建一个 Employee 对象，相当于是 employee.getUsername()

        Employee emp = employeeService.getOne(queryWrapper);

        // 没有查到该用户
        if(emp == null) {
            return R.error("登录失败");
        }

        // 密码不一致
        if(!emp.getPassword().equals(password)) {
            return R.error("密码错误");
        }

        if(emp.getStatus() == 0) {
            return R.error("账号已禁用");
        }

        // 将用户 id 存入 session
        request.getSession().setAttribute("employee", emp.getId());

        return R.success(emp);
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        // 移除 Session 中保存的当前登录员工的 id
        request.getSession().removeAttribute("employee");

        return R.success("退出成功");
    }
}
