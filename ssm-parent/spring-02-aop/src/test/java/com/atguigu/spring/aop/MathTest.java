package com.atguigu.spring.aop;

import com.atguigu.spring.aop.calculator.MathCalculator;
import com.atguigu.spring.aop.calculator.impl.MathCalculatorImpl;
import com.atguigu.spring.aop.proxy.dynamic.DynamicProxy;
import com.atguigu.spring.aop.proxy.statics.CalculatorStaticProxy;
import com.atguigu.spring.aop.service.UserService;
import com.atguigu.spring.aop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 18:59
 */
public class MathTest {

    @Test
    void test01() {
        MathCalculator target = new MathCalculatorImpl();
        int add = target.add(1, 2);
        System.out.println(add);

        System.out.println("-----------------");

        // 创建一个静态代理对象
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(target);
        int add1 = calculatorStaticProxy.add(3, 2);
        System.out.println(add1);
    }

    @Test
    void test02() {
        // 1. 原生对象
        MathCalculatorImpl target = new MathCalculatorImpl();

        // 2. 动态代理是Java原生支持

        /**
         * ClassLoader loader：类加载器（目标对象的类加载器）
         * Class<?>[] interfaces：目标对象实现的接口类型
         * InvocationHandler h：执行代理方法时，调用哪个InvocationHandler对象
         */
        // 3. 创建动态代理
        // InvocationHandler类似于拦截器
        MathCalculator proxyInstance = (MathCalculator)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("InvocationHandler的invoke在运行...");
            // 目标方法执行
            Object result = method.invoke(target, args);
            return result;
        });

        int add = proxyInstance.add(1, 2);
        System.out.println(add);
    }

    @Test
    void test03() {
        MathCalculator proxyInstance = (MathCalculator) DynamicProxy.getProxyInstance(new MathCalculatorImpl());
        proxyInstance.add(1, 2);

        UserService instance = (UserService) DynamicProxy.getProxyInstance(new UserServiceImpl());
        instance.saveUser();
    }
}
