package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> list(String name, Short gender, LocalDate startDate, LocalDate endDate);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(name, head, age, gender, phone, entry_date, create_time, update_time) " +
            "values (#{name}, #{head}, #{age}, #{gender}, #{phone}, #{entryDate}, #{createTime}, #{updateTime})")
    int add(User user);

    @Update("update user set name=#{name}, head=#{head}, age=#{age}, gender=#{gender}, phone=#{phone}," +
            "entry_date=#{entryDate}, update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);

    public void batchDelete(List<Integer> ids);
}
