package com.atguigu.restful.crud.advice;

import com.atguigu.restful.crud.common.R;
import com.atguigu.restful.crud.exception.BizException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 17:06
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionController {

    // 全局异常处理方法的返回值确实起到了"放行"和"响应"的作用
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 当前只是返回了异常信息，没有具体的错误字段信息
        // return R.error(e.getMessage());

        // result中封装了所有错误信息
        BindingResult result = e.getBindingResult();
        HashMap<String, String> errorMap = new HashMap<>();
        // 拿到所有属性错误的信息
        for (FieldError fieldError : result.getFieldErrors()) {
            // 拿到属性名
            String field = fieldError.getField();
            // 拿到错误信息
            String defaultMessage = fieldError.getDefaultMessage();
            errorMap.put(field, defaultMessage);
        }
        return R.error(500, "校验失败", errorMap);
    }


    @ExceptionHandler(BizException.class)  // 确保参数类型正确
    public R handleBizException(BizException e) {
        System.out.println(e.getMessage());
        return R.error(500, "数据库存储异常", e.getMessage());
    }

    // 处理约束违反异常（可能由自定义注解引起）
    /* @ExceptionHandler(ConstraintViolationException.class)
    public R handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();
        e.getConstraintViolations().forEach(violation -> {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(propertyPath, message);
        });
        return R.error(400, "参数校验失败", errors);
    }
*/
    // 处理其他所有异常（兜底处理）
    @ExceptionHandler(Exception.class)
    public R handleGeneralException(Exception e) {
        e.printStackTrace(); // 打印异常堆栈，便于调试
        return R.error(500, "服务器内部错误: ", e.getMessage());
    }

}