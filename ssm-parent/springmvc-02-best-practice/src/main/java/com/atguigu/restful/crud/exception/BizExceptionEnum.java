package com.atguigu.restful.crud.exception;

import lombok.Getter;

/**
 * 无限进步!!!
 * Description:
 *
 * @Author AU
 * @Create: 2025-09-16 11:25
 * @Version: 1.0
 */
// 该类会动态扩充
public enum BizExceptionEnum {

    // ORDER_xxx：订单模块相关异常
    // PRODUCT_xxx：商品模块相关异常
    ORDER_CLOSED(10001, "订单已关闭"),
    ORDER_NOT_EXIST(10002, "订单不存在"),
    ORDER_TIMEOUT(10003, "订单超时"),

    PRODUCT_STOCK_NOT_ENOUGH(20003, "商品库存不足"),
    PRODUCT_HAS_SOLD(20002, "商品已售完"),
    PRODUCT_HAS_CLOSED(20001, "商品已下架");


    @Getter
    private final Integer code;
    @Getter
    private final String message;

    private BizExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
