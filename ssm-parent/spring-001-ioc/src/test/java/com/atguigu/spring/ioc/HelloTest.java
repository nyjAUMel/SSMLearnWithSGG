package com.atguigu.spring.ioc;

import com.atguigu.spring.ioc.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * Description:
 *
 * @Author nyjAUMel
 * @Create: 2025-09-10 18:36
 */
@SpringBootTest
public class HelloTest {

    @Autowired
    private User user;
    @Test
    public void test01() {
        System.out.println(user);
    }

    @Test
    public void test(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
