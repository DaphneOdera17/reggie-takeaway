package com.birdy.reggie.common;

/**
 * @author Birdy
 * @date 2025/2/2 14:43
 * @description BaseContext 用来保存当前线程的当前登录用户 id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
