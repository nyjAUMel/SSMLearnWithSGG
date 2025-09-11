package com.atguigu.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 10:45
 */
@Order(1)
@Component
@Aspect // 告诉这个组件是个切面
public class LogAspect {

    /**
     * 定义一个切点，用于匹配特定方法的执行。
     * <p>
     * 该切点匹配所有在 com.atguigu.spring.aop.calculator.MathCalculator 类中定义的
     * 返回类型为 int 的方法的执行。
     */
    @Pointcut("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    public void pointCut() {
    }


    /*
    告诉Spring以下通知方法何时何地运行
        何时：
            @Before：方法执行之前运行
            @AfterReturning：方法正常返回之后运行
            @AfterThrowing：方法抛出异常时运行
            @After：方法执行之后运行
            @Around：环绕通知，可以控制目标方法是否执行，修改目标方法参数、执行结果等。

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
    //@Before("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        // 拿到方法全签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 方法名
        String name = signature.getName();
        // 目标方法传来的参数值
        Object[] args = joinPoint.getArgs();
        System.out.println("【切面 - 日志】【" + name + "】开始；参数列表【" + Arrays.toString(args) + "】...");
    }

    //@After("execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))")
    @After("pointCut()")
    public void logEnd() {
        System.out.println("【切面 - 日志】结束...");
    }

    //@AfterThrowing(value = "execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))", throwing = "e")
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】异常..." + e.getMessage());
    }

    //@AfterReturning(value = "execution(int com.atguigu.spring.aop.calculator.MathCalculator.*(..))", returning = "result") // returning = "result" 表示获取目标方法返回值
    @AfterReturning(value = "pointCut()", returning = "result") // returning = "result" 表示获取目标方法返回值
    public void logReturn(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】正常返回..." + result);
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
