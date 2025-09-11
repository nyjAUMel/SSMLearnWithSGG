package com.atguigu.spring.aop.annoation;

import java.lang.annotation.*;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 11:48
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAn {

}
