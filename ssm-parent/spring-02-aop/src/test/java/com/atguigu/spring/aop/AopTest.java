package com.atguigu.spring.aop;

import com.atguigu.spring.aop.calculator.MathCalculator;
import com.atguigu.spring.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 10:59
 */
@SpringBootTest
public class AopTest {

    @Autowired // 一旦有了切面，容器中就会生成代理对象。所以这里已经不是原始的实现对象mathCalculatorImpl了
    private MathCalculator mathCalculator;

    @Autowired
    private UserService userService;

    @Test
    void test01() {
        //mathCalculator.add(1, 2);

        userService.getUser(1, 2);
        /*
         * AOP的底层原理
         *   1、Spring会为每个被切入面的组件创建代理对象（Spring CGLIB 创建的代理，无视接口）
         *   2、代理对象中保存了切面类型里所有通知方法构成的增强器链
         *   3、目标方法执行时，会先去执行增强器链中拿到需要提前执行的通知方法去执行
         *  */
        //userService.updateUser(new Object());
    }

    @Test
    void test02() {
        mathCalculator.div(2, 2);
    }
}
