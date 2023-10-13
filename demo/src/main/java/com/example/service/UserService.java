package com.example.service;

import com.example.pojo.PageBean;

import java.time.LocalDate;

public interface UserService {
    PageBean list(String name, Short gender, LocalDate startDate, LocalDate endDate, Integer page, Integer pageSize);
}
