package com.atguigu.spring.aop.log;

import java.util.Arrays;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 10:19
 */
public class LogUtils {
    public static void logStart(String methodName, Object... args) {
        System.out.println("【日志】，【" + methodName + "】开始：参数：【" + Arrays.asList(args) + "】");
    }

    public static void logEnd(String methodName, Object result) {
        System.out.println("【日志】，【" + methodName + "】结束：结果：【" + result + "】");
    }

    public static void logException(String methodName, Throwable e) {
        System.out.println("【日志】，【" + methodName + "】异常：异常信息：【" + e.getMessage() + "】");
    }
    public static void logResult(String methodName, Object result) {
        System.out.println("【日志】，【" + methodName + "】返回值：【" + result + "】");
    }
}
