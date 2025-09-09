package com.atguigu.spring.ioc.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-09 14:07
 */
/*
Spring默认从application.properties文件中获取属性值
    @PropertySource用来指定属性来源。简单来说这个注解把指定文件导入到Spring容器中，供使用。

    1. classpath:cat.properties：从自己的项目路径下找
        补充：如果有多级目录可加上classpath:conf/cat.properties
    2. classpath*:cat.properties：从所有包的类路径下找
        如：
            classpath*:Log4j-charsets.properties
 */
@PropertySource("classpath:cat.properties")
@Component
@Data
public class Cat {

    // 冒号表示值取不到时的默认值
    @Value("${cat.name:Cat}")
    private String name;
    @Value("${cat.age:32}")
    private Integer age;
}
