package com.atguigu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 19:23
 */
@Controller // 告诉Spring这是一个控制器（处理请求的组件）
public class HelloController {

    /**
     * 路径位置通配符：通配符优先级低，精确程度优先（全 > ? > * > **）
     *      ? 匹配一个字符
     *      * 匹配任意数量的字符（可以为0）
     *      ** 匹配任意数量的路径
     * @return
     */
    @ResponseBody // @ResponseBody 注解在 Spring MVC 中的作用是将方法的返回值直接作为响应体返回给客户端，而不是解析为视图名称。
    @RequestMapping("/hell*/**") // 告诉Spring这是一个处理请求的映射
    public String handle04() {
        // 这么些默认时返回视图名，但前后端分离项目返回的就是数据，所以要加注解@ResponseBody
        return "**标识多层路径";
    }


    @ResponseBody // @ResponseBody 注解在 Spring MVC 中的作用是将方法的返回值直接作为响应体返回给客户端，而不是解析为视图名称。
    @RequestMapping("/hell*") // 告诉Spring这是一个处理请求的映射
    public String handle03() {
        // 这么些默认时返回视图名，但前后端分离项目返回的就是数据，所以要加注解@ResponseBody
        return "一个*号路径";
    }

    @ResponseBody // @ResponseBody 注解在 Spring MVC 中的作用是将方法的返回值直接作为响应体返回给客户端，而不是解析为视图名称。
    @RequestMapping("/hell?") // 告诉Spring这是一个处理请求的映射
    public String handle02() {
        // 这么些默认时返回视图名，但前后端分离项目返回的就是数据，所以要加注解@ResponseBody
        return "一个?号路径";
    }


    @ResponseBody // @ResponseBody 注解在 Spring MVC 中的作用是将方法的返回值直接作为响应体返回给客户端，而不是解析为视图名称。
    @RequestMapping("/hello") // 告诉Spring这是一个处理请求的映射
    public String handle() {
        // 这么些默认时返回视图名，但前后端分离项目返回的就是数据，所以要加注解@ResponseBody
        return "一个精确路径";
    }

}
