package com.atguigu.spring.ioc.factory;

import com.atguigu.spring.ioc.bean.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 18:41
 */
// 场景：如果制造某些对象比较复杂的时候，可以使用工厂模式
@Component
public class BYDFactory implements FactoryBean<Car> {
    /*
    * 调用此方法给容器中创建一个对象
    *  */
    @Override
    public Car getObject() throws Exception {
        System.out.println("BYD Factory正在制造Car对象");
        return new Car();
    }

    /*
    * 说明造东西的类型
    *  */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /*
    * 是单例吗？
    *  */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
