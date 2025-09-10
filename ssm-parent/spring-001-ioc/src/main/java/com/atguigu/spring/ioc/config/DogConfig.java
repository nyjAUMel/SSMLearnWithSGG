package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.bean.Dog;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
    // 表示当容器中没有bill对象时，讲这个bean放进容器当中
    // 不过这个底层好像有BUG
    @ConditionalOnMissingBean(name = "bill")
    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Dog dog1() {
        Dog dog = new Dog();
        dog.setName("灰太狼");
        return dog;
    }

    @Bean
    public Dog dog2() {
        Dog dog = new Dog();
        dog.setName("双叉狼");
        return dog;
    }
}
