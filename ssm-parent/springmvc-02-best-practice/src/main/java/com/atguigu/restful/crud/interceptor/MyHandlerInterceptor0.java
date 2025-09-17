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
    对于多个拦截器执行问题：可以将多个拦截器竖着从左至右排列开。
        1. preHandle顺序执行 2.postHandle倒叙执行 3.afterCompletion逆序执行。
        注意：
            preHandle方法返回false，则目标方法不会执行，但是afterCompletion方法都会执行
            postHandle只有在目标方法执行完以后才会执行，如果中途preHandle没有放行就不会执行目标方法，自然也不会执行postHandle
                在这个环境下发生错误不会影响afterCompletion，但是后面（倒叙，所以顺序上应该是前面的拦截器）执行的postHandle就不会执行了
            afterCompletion在同拦截器的preHandle方法执行成功后（放行）就一定会执行
                在这个环境下发生错误，后面（倒叙，所以顺序上应该是前面的拦截器）的afterCompletion也不会执行了
 */
@Component
public class MyHandlerInterceptor0 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle0...执行");
        // 放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle0...执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion0...执行");
    }
}
