package com.atguigu.restful.crud.controller;

import com.atguigu.restful.crud.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-16 10:11
 */

/**
 * 异常处理的逻辑是本类优先、精确优先
 * 本类优先：就是说，如果有多个异常处理类的方法，优先执行本类中定义的异常处理方法
 * 精确优先：如果有Exception和ArithmeticException异常，则优先执行ArithmeticException异常处理方法，因为精确优先
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public R hello(@RequestParam(value = "i", defaultValue = "0") Integer i) {
        //int j = 10 / i;
        String str = null;
        str.toString();
        return R.ok();
    }


    /**
     * 1. 如果本Controller类里的方法执行时抛出异常，会自动在本类中寻找有没有被@ExceptionHandler()标注的方法，
     * 如果有，执行这个方法。它的返回值就是客户端收到的数据（当然，应该需要@ResponseBody注解，不过这里用了@RestController）
     * 抛出ArithmeticException异常，则执行本方法。
     * <p>
     * 注解的参数ArithmeticException.class表示只有发生了算数异常该方法才会执行
     * 方法的参数
     *
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    public R handlerArithmeticException(ArithmeticException ae) {
        return R.error(100, "执行异常" + ae.getMessage());
    }

    /**
     * 接受两个异常类
     *
     * @param ne
     * @return
     */
    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public R NullPointerAndFileNotFoundException(NullPointerException ne) {
        return R.error(200, "文件没找到或空指针" + ne.getMessage());
    }

    /**
     * 这个解决了要写多个异常处理的问题，直接接受个大的
     *
     * @param t
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public R ThrowableException(Throwable t) {
        return R.error(300, "大异常" + t.getMessage());
    }
}
