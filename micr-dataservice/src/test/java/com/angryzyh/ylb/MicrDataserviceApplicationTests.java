package com.angryzyh.ylb;

import com.angryzyh.ylb.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicrDataserviceApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = userMapper.selectCount(null);
        System.out.println("aLong = " + aLong);

    }

}
