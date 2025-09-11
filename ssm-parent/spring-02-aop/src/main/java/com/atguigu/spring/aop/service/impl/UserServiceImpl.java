package com.atguigu.spring.aop.service.impl;

import com.atguigu.spring.aop.annoation.MyAn;
import com.atguigu.spring.aop.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 19:52
 */

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("业务：保存用户");
    }

    @Override
    public void getUser(int a, int b) {
        System.out.println("业务：获取用户");
    }

    @MyAn
    @Override
    public void updateUser(Object o) {
        System.out.println("哈哈哈哈哈哈....MyAn注解");
    }
}
