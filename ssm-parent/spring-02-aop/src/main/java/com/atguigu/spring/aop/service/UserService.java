package com.atguigu.spring.aop.service;

import com.atguigu.spring.aop.annoation.MyAn;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 19:52
 */

public interface UserService {

    void saveUser();
    void getUser(int a, int b);

    void updateUser(Object o);
}
