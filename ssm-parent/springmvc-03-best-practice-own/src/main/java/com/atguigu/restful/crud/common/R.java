package com.atguigu.restful.crud.common;

import lombok.Data;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-18 16:11
 */
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("SUCCESS");
        return r;
    }

    // 确保返回的 R 对象的类型参数与传入的数据类型一致
    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("SUCCESS");
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(Integer code, String msg, T data) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static <T> R<T> error() {
        R<T> r = new R<>();
        r.setCode(500);
        r.setMsg("ERROR");
        return r;
    }
}
