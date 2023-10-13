package com.example.controller;

import com.example.exception.AgeIllegalException;
import com.example.mapper.UserMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public Result list(String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("Hello World");
        PageBean list = userService.list(name, gender, start, end, page, pageSize);
        return Result.success(list);
    }

    @RequestMapping("add")
    public Result add() {
        User user = new User();
        user.setName("Spring");
        user.setAge(20);
        user.setHead("666.png");
        user.setGender((short) 2);
        user.setPhone("15899999999");
        user.setEntryDate(LocalDate.of(2023, 1, 1));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        int insertId = userMapper.add(user);
        System.out.println(insertId);
        return Result.success();
    }

    @RequestMapping("update")
    public Result update() {
        User user = new User();
        user.setId(1);
        user.setName("Mybatis");
        user.setAge(20);
        user.setHead("666.png");
        user.setGender((short) 1);
        user.setPhone("15899999999");
        user.setEntryDate(LocalDate.of(2023, 9, 1));
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
        return Result.success();
    }

    @RequestMapping("delete")
    public Result delete(Integer id) {
        userMapper.delete(id);
        return Result.success();
    }

    public void checkAge(int age) {
        if (age > 0 && age < 150) {
            System.out.println("age is save");
        } else {
            throw new AgeIllegalException("age is illegal: " + age);
        }
    }
}
