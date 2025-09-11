package com.atguigu.spring.aop.calculator.impl;

import com.atguigu.spring.aop.calculator.MathCalculator;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 18:47
 */

/*
    日志的几种：
        1. 硬编码（不推荐）：高耦合（通用逻辑 + 专用逻辑）
        2. 静态代理
            定义：定义一个代理对象，包装这个组件。以后业务的执行从代理开始，不直接调用组件
            特点：在定义期间就指定好了互相代理关系

 */

@Component
public class MathCalculatorImpl implements MathCalculator {
    @Override
    public int add(int a, int b) {
        System.out.println("目标方法执行...");
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("目标方法执行...");
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("目标方法执行...");
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("目标方法执行...");
        return a / b;
    }
}
