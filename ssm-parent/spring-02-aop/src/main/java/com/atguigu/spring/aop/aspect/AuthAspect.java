package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 15:03
 */
@Order(2) // 多切面时的优先级，数字越小越先执行
@Aspect
@Component
public class AuthAspect {

    @Pointcut("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("【切面 - 权限】前置");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("【切面 - 权限】后置");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("【切面 - 权限】返回后");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("【切面 - 权限】异常后");
    }
}
