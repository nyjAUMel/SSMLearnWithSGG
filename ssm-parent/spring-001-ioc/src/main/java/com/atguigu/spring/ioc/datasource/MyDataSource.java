package com.atguigu.spring.ioc.datasource;

import lombok.Data;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-09 14:29
 */
@Data
public class MyDataSource {
    private String driver;
    private String url;
    private String username;
    private String password;
}
