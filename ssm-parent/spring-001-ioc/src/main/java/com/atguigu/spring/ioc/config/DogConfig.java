package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 14:51
 */
@Configuration
public class DogConfig {

    @Lazy // 通常@Scope为默认单例时使用，因为非单例创建对象之有在获取时才创建对象。
    @Bean("dog")
    public Dog dog() {
        return new Dog();
    }
}
