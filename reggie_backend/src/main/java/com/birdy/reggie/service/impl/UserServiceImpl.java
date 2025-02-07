package com.birdy.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.birdy.reggie.entity.User;
import com.birdy.reggie.mapper.UserMapper;
import com.birdy.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Birdy
 * @date 2025/2/7 20:40
 * @description UserServiceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
