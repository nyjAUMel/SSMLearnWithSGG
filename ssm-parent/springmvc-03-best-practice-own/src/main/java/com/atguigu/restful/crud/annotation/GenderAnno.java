package com.atguigu.restful.crud.annotation;

import com.atguigu.restful.crud.validator.GenderValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 16:31
 */
@Documented
@Constraint(
        validatedBy = {GenderValidator.class}
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RUNTIME)
public @interface GenderAnno {
    String message() default "{jakarta.validation.constraints.Gender.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
