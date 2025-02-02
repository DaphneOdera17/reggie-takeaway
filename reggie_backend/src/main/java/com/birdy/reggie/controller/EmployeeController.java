package com.birdy.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.birdy.reggie.common.R;
import com.birdy.reggie.entity.Employee;
import com.birdy.reggie.service.EmployeeService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


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

    /**
     * 新增员工
     * @param employee
     * @param request
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee) {
        log.info("新增员工信息: {}", employee.toString());

        // 设置员工初始密码为 123456，并用 md5 加密
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        /*
            employee.setCreateTime(LocalDateTime.now());
            employee.setUpdateTime(LocalDateTime.now());

            employee.setCreateUser((Long) request.getSession().getAttribute("employee"));
            employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));
        */

        employeeService.save(employee);

        return R.success("新增员工成功");
    }

    /**
     * 员工信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        // 构建分页构造器
        Page pageInfo = new Page(page, pageSize);

        // 构建条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();

        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        employeeService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * 根据 id 修改员工信息
     * @param employee
     * @param request
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee) {
        /*
            employee.setUpdateTime(LocalDateTime.now());
            employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));
        */

        employeeService.updateById(employee);

        return R.success("员工信息修改成功");
    }

    /**
     * 根据 id 查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        if(employee != null) {
            return R.success(employee);
        }
        return R.error("未查到该员工信息!");
    }
}
