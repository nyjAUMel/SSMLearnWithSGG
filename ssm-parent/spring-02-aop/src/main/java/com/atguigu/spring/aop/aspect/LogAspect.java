package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 10:45
 */
@Component
@Aspect // 告诉这个组件是个切面
public class LogAspect {
    /*
    告诉Spring以下通知方法何时何地运行
        何时：
            @Before：方法执行之前运行
            @AfterReturning：方法正常返回之后运行
            @AfterThrowing：方法抛出异常时运行
            @After：方法执行之后运行
        何地：
            切入点表达式：
                execution(方法的全签名)：
                    全写法：[public] 返回值类型 [方法所在包名.类名].方法名(参数类型) [throws xxx]
                    省略写法 int add(int a, int b)
                    通配符：
                        *：表示任意字符
                        ..：
                            1. 在参数位置：表示任意多个参数，任意类型
                                如add(..)表示随便个数随便类型的参数
                            2. 在包位置：代表多个层级
                    最省略：* *(..) 标识返回值任意，方法名任意，参数任意

    通知方法的执行顺序
        1. 正常链路：1. 前置通知 2. 目标方法 3. 返回通知 4. 后置通知
        2. 异常链路：1. 前置通知 2. 目标方法 3. 异常通知 4. 后置通知

     */
    //@Before("execution(int add(int, int))") 为方法名为add且参数是两个int的方法添加切面
    //@Before("execution(int *(int, int))") // 为任意方法名且参数是两个int的方法添加切面
    @Before("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void logStart() {
        System.out.println("【切面 - 日志】开始...");
    }

    @After("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void logEnd() {
        System.out.println("【切面 - 日志】结束...");
    }

    @AfterThrowing("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void logException(Throwable e) {
        System.out.println("【切面 - 日志】异常...");
    }

    @AfterReturning("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void logReturn() {
        System.out.println("【切面 - 日志】正常返回...");
    }

    // 这个表示当参数为两个 int 类型时前置切入
    @Before("args(int,int)")
    public void logArgs() {
        System.out.println("【切面 - 日志】参数");
    }

    /*
        @args:这个表示当参数有注解修饰时切入
        within: 这个表示方法所在包或者子包下的方法切入
     */
    @Before("@args(com.atguigu.spring.aop.annoation.MyAn) && within(com.atguigu.spring.aop.service.UserService)")
    public void logArgs2() {
        System.out.println("【切面 - 日志】参数2");
    }

    // 表示方法上有注解时切入
    @Before("@annotation(com.atguigu.spring.aop.annoation.MyAn)")
    public void logAnnotation() {
        System.out.println("【切面 - 方法上有参数】注解");
    }
}
