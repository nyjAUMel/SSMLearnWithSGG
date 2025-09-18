package com.atguigu.restful.crud.validator;

import com.atguigu.restful.crud.annotation.GenderAnno;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 16:35
 */
public class GenderValidator implements ConstraintValidator<GenderAnno, String> {

    /**
     *
     * @param s 前端提交来准备验证的数据
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(s);
        return s.equals("男") || s.equals("女");
    }
}
