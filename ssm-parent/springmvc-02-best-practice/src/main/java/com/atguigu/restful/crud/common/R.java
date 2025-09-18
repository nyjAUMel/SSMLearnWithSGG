package com.atguigu.restful.crud.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-14 19:22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
// 只要是描述JavaBean都用@Schema
@Schema(description = "统一返回结果类")
public class R<T> {
    @Schema(description = "状态码")
    private Integer code;
    @Schema(description = "提示信息")
    private String msg;
    @Schema(description = "数据")
    private T data;

    /*
    第一个 <T> - 方法声明中的泛型参数
        这是 方法级别的泛型声明，意思是这个方法是一个泛型方法，可以接收一个类型参数 T。就像你在类上写 class Box<T> {} 一样，只不过这里是在方法上。
    第二个 R<T> - 方法的返回类型
        这里的 R<T> 表示这个方法返回一个带泛型参数的 R 类型（可能是你项目里的一个通用返回对象）。
        它里面的 T 就是前面 <T> 定义的类型参数。
     */
    public static <T> R<T> ok(T data) {
        R<T> tr = new R<>();
        tr.setCode(200);
        tr.setMsg("ok");
        tr.setData(data);
        return tr;
    }

    public static <T> R<T> ok() {
        R<T> tr = new R<>();
        tr.setCode(200);
        tr.setMsg("ok");
        return tr;
    }

    public static <T> R<T> error() {
        R<T> tr = new R<>();
        tr.setCode(500); // 默认失败码
        tr.setMsg("error");
        return tr;
    }

    public static <T> R<T> error(Integer code, String msg) {
        R<T> tr = new R<>();
        tr.setCode(code);
        tr.setMsg(msg);
        return tr;
    }

    public static <T> R<T> error(Integer code, String msg, T data) {
        R<T> tr = new R<>();
        tr.setCode(code);
        tr.setMsg(msg);
        tr.setData(data);
        return tr;
    }
}
