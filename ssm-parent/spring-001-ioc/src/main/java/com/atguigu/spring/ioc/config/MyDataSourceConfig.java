package com.atguigu.spring.ioc.config;

import com.atguigu.spring.ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-09 14:36
 */
//@Profile("dev") // 这个注解也可以标识在类上，标识激活整个类才能去谈后面的配置
@Configuration // 告诉Spring这是一个专门用来配置Bean的类
public class MyDataSourceConfig {

    /*
     1、 定义环境标识：自定义（dev、test、prod）；默认环境为（default）
     2、 激活环境标识：
            明确告诉Spring容器当前处于什么环境：去配置文件application.properties中添加spring.profiles.active=要激活的环境标识
            如果不明确指示就是默认default环境
    */

    /*
    @Profile 注解是Spring框架中用于实现环境隔离和条件化Bean注册的重要注解。
        主要作用
            环境隔离：根据不同环境（开发、测试、生产等）加载不同的Bean配置
            条件化注册：只有在指定的Profile激活时，被注解的Bean才会被注册到Spring容器中
     */
    @Profile({"dev", "default"})
    @Bean
    public MyDataSource dev() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setDriver("com.mysql.jdbc.Driver");
        myDataSource.setUrl("jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=utf8");
        myDataSource.setUsername("root");
        myDataSource.setPassword("root");
        return myDataSource;
    }

    @Profile("test")
    @Bean
    public MyDataSource test() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setDriver("com.mysql.jdbc.Driver");
        myDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
        myDataSource.setUsername("root");
        myDataSource.setPassword("root");
        return myDataSource;
    }

    @Profile("prod")
    @Bean
    public MyDataSource prod() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setDriver("com.mysql.jdbc.Driver");
        myDataSource.setUrl("jdbc:mysql://localhost:3306/prod?useUnicode=true&characterEncoding=utf8");
        myDataSource.setUsername("root");
        myDataSource.setPassword("root");
        return myDataSource;
    }
}
