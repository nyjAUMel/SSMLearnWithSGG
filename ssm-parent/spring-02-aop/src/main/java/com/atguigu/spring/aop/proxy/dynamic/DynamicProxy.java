package com.atguigu.spring.aop.proxy.dynamic;

import com.atguigu.spring.aop.log.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 19:44
 */
/*
 * 动态代理：JDK动态代理：强制要求目标对象必须有接口。代理的也只是接口规定的方法
 */
public class DynamicProxy {
    // 这个没有用LogUtils工具类输出日志
    /* public static Object getProxyInstance(Object target) {
         *//*
        proxy 参数代表的是通过 Proxy.newProxyInstance() 创建出来的代理对象
         *//*
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            // 获取真正执行的方法名
            String name = method.getName();
            // 这段代码是为了防止args空指针
            args = args == null ? new Object[0] : args;
            System.out.println("【日志】，【" + name + "】开始：参数：【" + Arrays.asList(args) + "】");
            // （调add方法）method就是add方法的Method对象
            // 动态代理的精髓：同一个 invoke 方法可以处理目标对象的所有方法调用，通过 method 参数来区分具体调用的是哪个方法。
            Object result = method.invoke(target, args);
            System.out.println("【日志】，【" + name + "】结束：结果：【" + result + "】");

            return result;
        });
    } */


    // 这个用到了LogUtils工具类输出日志
    public static Object getProxyInstance(Object target) {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            String name = method.getName();
            args = args == null ? new Object[0] : args;
            // 记录开始
            LogUtils.logStart(name, args);
            Object result = null;
            try {
                result = method.invoke(target, args);
                // 记录返回值
                LogUtils.logResult(name,result);
            } catch (IllegalAccessException e) {
                // 记录异常
                LogUtils.logException(name,e);
            } finally {
                // 记录结束
                LogUtils.logEnd(name,result);
            }

            return result;
        });
    }
}
