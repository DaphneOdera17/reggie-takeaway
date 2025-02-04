package com.birdy.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.birdy.reggie.entity.Category;

/**
 * @author Birdy
 * @date 2025/2/3 13:45
 * @description CategoryService
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
