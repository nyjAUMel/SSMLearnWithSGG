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

    // 表示当容器中有jobs对象时，将这个bean放进容器当中
    //@ConditionalOnBean(name = "jobs")
    //@Lazy // 通常@Scope为默认单例时使用，因为非单例创建对象之有在获取时才创建对象。
    @Bean("dog")
    public Dog dog() {
        return new Dog();
    }
}
