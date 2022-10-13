package com.angryzyh.ylb;

import com.angryzyh.ylb.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MicrDataserviceApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = userMapper.selectCount(null);
        System.out.println("aLong = " + aLong);

        List<Double> list = new ArrayList<>();
        list.add(4.60);
        list.add(67.60);
        list.add(4.30);
        list.add(72.60);
        list.add(94.42);
        list.add(30.74);

        List<Double> collect = list.stream().sorted((x1, x2) -> {
            String s1 = x1.toString().replaceAll("\\.", "");
            Integer integer1 = Integer.valueOf(s1);
            String s2 = x2.toString().replaceAll("\\.", "");
            Integer integer2 = Integer.valueOf(s2);
            return integer2 - integer1;
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
