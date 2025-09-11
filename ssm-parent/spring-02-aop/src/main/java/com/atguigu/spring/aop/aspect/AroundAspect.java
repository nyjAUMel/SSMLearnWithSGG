package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 16:07
 */
@Aspect
@Component
public class AroundAspect {

    @Pointcut("execution(* com.atguigu.spring.aop.calculator.*.*(..))")
    public void pointCut() {
    }

    /**
     * 环绕通知固定写法
     * Object：返回值
     * ProceedingJoinPoint：可以继续推进的切点
     *
     * @return
     * @throws Throwable
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("【前置】环绕通知" + Arrays.toString(args));
        Object proceed = null;
        try {
            proceed = joinPoint.proceed(args); // 继续目标方法执行；反射method.invoke();
            System.out.println("【返回】环绕通知：" + proceed);
        } catch (Exception e) {
            System.out.println("【异常】环绕通知" + e.getMessage());
            throw e; // 抛出异常，让外围的调用者知道发生了异常。因为环绕通知里不抛出异常。外层的切面方法就会走返回通知而非异常通知了
        } finally {
            System.out.println("【后置】环绕通知");
        }
        // 修改返回值
        return proceed;
    }
}
