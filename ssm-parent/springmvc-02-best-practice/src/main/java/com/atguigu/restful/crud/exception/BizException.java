package com.atguigu.restful.crud.exception;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-16 11:18
 */

import lombok.Data;

/**
 * 自定义业务异常
 *
 *
 * 异常处理的最终方式：
 *  1. 必须有业务异常类：BizException
 *  2. 必须有异常枚举类：BizExceptionEnum 列举项目中每个模块将会出现的所有异常
 *  3. 编写业务代码时，只需要编写正确逻辑，如果出现预期的问题，需要以抛异常的方式中断逻辑并通知上层
 *  4. 全局异常处理器：GlobalExceptionHandler：处理所有异常，返回给前端约定的JSON数据与错误码
 */
@Data
public class BizException extends RuntimeException{
    private Integer code; //业务异常码
    private String message; //业务异常信息

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }


    public BizException(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }
}
