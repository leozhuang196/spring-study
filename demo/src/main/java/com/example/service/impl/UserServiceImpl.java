package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.PageBean;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageBean list(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<User> userList = userMapper.list(name, gender, startDate, endDate);
        Page<User> p = (Page<User>) userList;

        return new PageBean(p.getTotal(), p.getResult());
    }
}
