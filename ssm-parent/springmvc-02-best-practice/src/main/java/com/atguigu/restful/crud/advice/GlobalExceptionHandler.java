package com.atguigu.restful.crud.advice;

import com.atguigu.restful.crud.common.R;
import com.atguigu.restful.crud.exception.BizException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-16 10:48
 */

/**
 * ControllerAdvice 注解的作用如下：
 * 全局异常处理：将该类标记为全局异常处理器，可以处理整个应用程序中所有控制器抛出的异常
 * 作用范围：它是一个组件注解，会被Spring容器扫描并注册为Bean，作用于所有的 @Controller 控制器。
 * <p>
 * 需要添加 @ResponseBody 注解：因为 @ControllerAdvice 本身不包含 @ResponseBody 的功能，如果要返回 JSON 格式的数据，必须在处理异常的方法上添加 @ResponseBody 注解。
 */
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    /*
        如果出现了异常，本类和全局类都不能处理，那么SpringMVC会兜底处理。也称为自适应处理（浏览器响应页面，移动端响应JSON）
            最佳实践：手动编写全局异常处理类，处理所有异常，然后返回JSON数据

        前端关心异常状态，后端正确业务流程。
        推荐：后端只编写正确的业务逻辑，如果出现业务问题，后端通过抛异常的方式提前中断业务逻辑，然后返回错误信息给前端。
     */
    @ExceptionHandler(Throwable.class)
    public R throwableException(Throwable t) {
        System.out.println("【全局】兜底处理异常");
        return R.error(500, t.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        System.out.println("【全局】Exception异常");
        e.printStackTrace();
        System.out.println("---------------------------");
        // 获取异常发生的具体类和方法
        StackTraceElement[] stackTrace = e.getStackTrace();
        if (stackTrace.length > 0) {
            StackTraceElement element = stackTrace[0];
            System.out.println("异常发生位置: " + element.getClassName() + "." + element.getMethodName() +
                    "(" + element.getFileName() + ":" + element.getLineNumber() + ")");
        }
        return R.error(500, e.getMessage());
    }

    @ExceptionHandler(ArithmeticException.class)
    public R handleException(ArithmeticException ae) {
        System.out.println("【全局】精确优先处理数学异常");
        return R.error(500, ae.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleException(MethodArgumentNotValidException ex) {
        System.out.println("【全局】MethodArgumentNotValidException异常");
        // result中封装了所有错误信息
        BindingResult result = ex.getBindingResult();
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

    /**
     * 当应用程序的其他地方执行了类似 throw new BizException(BizExceptionEnum be) 的代码时，Spring MVC 会捕获这个异常，并将其传递给 @ControllerAdvice 标记的全局异常处理器。
     * @return
     */
    @ExceptionHandler(BizException.class)
    public R handleBizException(BizException be) {
        System.out.println("【全局】BizException异常");

        Integer code = be.getCode();
        String message = be.getMessage();
        return R.error(code, message);
    }

}
