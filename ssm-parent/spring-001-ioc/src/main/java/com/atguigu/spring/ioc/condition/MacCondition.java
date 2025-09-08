package com.atguigu.spring.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-08 19:58
 */
public class MacCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 判断环境变量中的OS包含mac就是mac系统
        Environment environment = context.getEnvironment();
        String os = environment.getProperty("OS");
        return os.contains("Mac");
    }
}
