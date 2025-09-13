package com.atguigu.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-11 20:11
 */
/*
@ResponseBody也可以标在类上，标识所有方法返回的都是数据，而不是视图名
@RestController就是@Controller和@ResponseBody的结合，所以两个可以简写成一个
 */
@RestController // 前后分离开发就用这个
public class RequestMappingLimitController {

    /**
     * value属性指定了请求路径，method属性限制了只接受POST方法。
     *
     * 请求方式：
     *      GET, POST, PUT, DELETE, PATCH, HEAD, OPTIONS, TRACE
     * @return
     */
    @RequestMapping(value = "/test01", method = RequestMethod.POST)
    public String test01() {
        return "请求方式的限制";
    }

    /**
     * params属性限制请求参数，只有当请求中包含指定名称的参数时才接受该请求。
     *  多个值写法：{}
     *      1. params = "id" 表示只有当请求中包含名为 id 的参数时，才会接受该请求。
     *      2. params = "id=1" 表示只有当请求中包含名为 id 且值为 1 的参数时，才会接受该请求。
     *      3. params = "id!=1" 表示只有当请求中包含名为 id 且值不为 1 的参数时，才会接受该请求。
     * @return
     */
    @RequestMapping(value = "/test02", params = {"id", "username=AU"})
    public String test02() {
        return "带参数的限制";
    }

    /**
     * headers属性限制请求头，只有当请求中包含指定名称的头部信息时才接受该请求。
     *  多个值写法：{}
     *      1. headers = "Content-Type" 表示只有当请求中包含名为 Content-Type 的头部信息时，才会接受该请求。
     *      2. headers = "Content-Type=application/json" 表示只有当请求中包含名为 Content-Type 且值为 application/json 的头部信息时，才会接受该请求。
     *      3. headers = "hhh!=1" 表示只有当请求中包含名为 hhh 且值不为 1 的头部信息时，才会接受该请求。
     * @return
     */
    @RequestMapping(value = "/test03", headers = {"hhh!=1"})
    public String test03() {
        return "请求头的限制";
    }

    /**
     * consumes属性限制请求的Content-Type，只有当请求的Content-Type符合指定类型时才接受该请求。
     *  就是说浏览器是数据提供者，我消费什么数据
     *  多个值写法：{}
     *      1. consumes = "application/json" 表示只有当请求的Content-Type为 application/json 时，才会接受该请求。
     * @return
     */
    @RequestMapping(value = "/test04", consumes = {"application/json"})
    public String test04() {
        return "Content-Type的限制";
    }

    /**
     * produces属性限制响应的Content-Type，只有当响应的Content-Type符合指定类型时才接受该请求。
     *  简而言之就是：指定给浏览器生产什么数据
     *      1. produces = "application/json" 表示只有当响应的Content-Type为 application/json 时，才会接受该请求。
     *      2. produces = "text/html" 表示只有当响应的Content-Type为 text/html 时，才会接受该请求。
     * @return
     */
    @RequestMapping(value = "/test05", produces = {"text/html"})
    public String test05() {
        return "<h1>响应的Content-Type的限制</h1>";
    }
}
