package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-09 19:04
 */
@Configuration
public class UserConfig {

    // initMethod 和 destroyMethod 的值规定了在 Bean类本身 中定义。
    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    public User user(){
        return new User();
    }
}
