package com.atguigu.spring.ioc.config;

import ch.qos.logback.core.CoreConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 18:15
 */
// 这个注解用来倒入类。可以导入非自定义类
@Import(CoreConstants.class)
// 默认分层注解要想起作用，这些组件必须在主程序所在的包及其子包结构下
// 用了该注解就可以扫描所有指定路径的注解（原默认情况会失效）
@ComponentScan("com.atguigu.spring.ioc")
public class AppConfig {
}
