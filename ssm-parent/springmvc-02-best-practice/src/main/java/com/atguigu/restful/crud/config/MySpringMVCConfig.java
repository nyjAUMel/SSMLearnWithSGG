package com.atguigu.restful.crud.config;

import com.atguigu.restful.crud.interceptor.MyHandlerInterceptor0;
import com.atguigu.restful.crud.interceptor.MyHandlerInterceptor1;
import com.atguigu.restful.crud.interceptor.MyHandlerInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-15 18:34
 */
/*
实现拦截器的 4 个步骤
    1. 创建类实现 HandlerInterceptor 接口
    2. 重写 preHandle、postHandle、afterCompletion 方法
    3. 创建配置类实现 WebMvcConfigurer，注册拦截器
        实现了 WebMvcConfigurer 接口后，其中的 addInterceptors 方法会在Spring MVC初始化时自动调用
    4. 使用 addPathPatterns 和 excludePathPatterns 设置拦截规则
 */

/*
    1. 容器中需要一个组件：WebMvcConfigurer：两种方法
        1. @Bean放一个组件WebMvcConfigurer
        2. 配置类实现WebMvcConfigurer接口
 */
@Configuration // 专门对SpringMVC底层进行一些配置
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    private MyHandlerInterceptor0 myHandlerInterceptor0;
    @Autowired
    private MyHandlerInterceptor1 myHandlerInterceptor1;
    @Autowired
    private MyHandlerInterceptor2 myHandlerInterceptor2;

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加第一个拦截器
        registry.addInterceptor(myHandlerInterceptor0)
                // // 拦截所有请求
                .addPathPatterns("/**");
        // 添加第二个拦截器
        registry.addInterceptor(myHandlerInterceptor1)
                // 拦截所有请求
                .addPathPatterns("/**");
        // 添加第三个拦截器
        registry.addInterceptor(myHandlerInterceptor2)
                /*
                    拦截/api/v1/employees下的请求
                        /** 的含义：匹配 0 个或多个目录层级
                    所以能够拦截到：http://localhost:8080/api/v1/employees
                 */
                .addPathPatterns("/api/v1/employees/**");
    }
    /* @Bean
    WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
            }
        };
    } */
}
