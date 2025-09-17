package com.atguigu.restful.crud.annotation;

import com.atguigu.restful.crud.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(
        // validatedBy = {} 用于指定验证器类，但在这个自定义注解中。也就是真正完成校验国能的类
        validatedBy = {
                GenderValidator.class
        }
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RUNTIME)
public @interface Gender {

    String message() default "{jakarta.validation.constraints.Gender.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
