package com.atguigu.restful.crud.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-15 18:09
 */
/*
实现拦截器的 4 个步骤
    1. 创建类实现 HandlerInterceptor 接口
    2. 重写 preHandle、postHandle、afterCompletion 方法
    3. 创建配置类实现 WebMvcConfigurer，注册拦截器
    4. 使用 addPathPatterns 和 excludePathPatterns 设置拦截规则
 */
@Component
public class MyHandlerInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle1...执行");
        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1...执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1...执行");
    }
}
