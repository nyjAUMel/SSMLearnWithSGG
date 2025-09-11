package com.atguigu.spring.aop.proxy.statics;

import com.atguigu.spring.aop.calculator.MathCalculator;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 18:55
 */
// 代理对象和目标对象实现相同的接口，代理对象实现目标对象功能，并添加额外的功能。
/*
 * 静态代理：编码期间就决定好了代理的关系。
 *      定义：代理对象，是目标对象的接口的子类型，代理对象本身并不是目标对象，而是将目标对象作为自己的属性。
 *      优点：同一种类型的对象都能代理
 *      缺点：范围太小，只能负责部分接口的代理
 *
 * 动态代理：运行期间才能确定关系（拦截器：拦截所有）
 *      定义：目标对象在执行期间会被动态拦截，插入指定逻辑
 *      优点：可以代理世间万物
 *
 */
@Data
public class CalculatorStaticProxy implements MathCalculator{

    private MathCalculator mathCalculator; // 目标对象

    public CalculatorStaticProxy(MathCalculator mc) {
        this.mathCalculator = mc;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("【日志】加法开始，参数是" + a + "，" + b);
        int result = this.mathCalculator.add(a,b);
        System.out.println("【日志】加法结束，结果是" + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        return this.mathCalculator.sub(a,b);
    }

    @Override
    public int mul(int a, int b) {
        return this.mathCalculator.mul(a,b);
    }

    @Override
    public int div(int a, int b) {
        return this.mathCalculator.div(a,b);
    }
}
