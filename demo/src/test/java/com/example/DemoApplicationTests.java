package com.example;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list("batt", null, null, null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testBatchDelete() {
        List<Integer> ids = Arrays.asList(1,2,3);
        userMapper.batchDelete(ids);
    }

}
