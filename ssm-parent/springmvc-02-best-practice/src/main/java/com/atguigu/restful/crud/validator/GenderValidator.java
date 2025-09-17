package com.atguigu.restful.crud.validator;

import com.atguigu.restful.crud.annotation.Gender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-17 14:44
 */
/*
 两个泛型：
    1. 泛型1：要实现的自定义注解类型
    2. 泛型2：要校验的目标数据类型
*/
public class GenderValidator implements ConstraintValidator<Gender, String> {

    /**
     *
     * @param value：前端提交来准备验证的数据
     * @param context：校验上下文
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "男".equals(value) || "女".equals(value);
    }
}
