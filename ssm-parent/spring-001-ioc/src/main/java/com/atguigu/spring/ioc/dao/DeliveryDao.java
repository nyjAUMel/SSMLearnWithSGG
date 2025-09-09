package com.atguigu.spring.ioc.dao;

import com.atguigu.spring.ioc.datasource.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-09 14:40
 */
@Component
public class DeliveryDao {

    @Autowired
    private MyDataSource myDataSource;

    public void saveDelivery() {
        System.out.println("数据源" + myDataSource + "正在保存信息");
    }
}
