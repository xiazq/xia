package com.example.demo2.dao;

import com.example.demo2.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersDao {


    Users queryById(Integer id);

    List<Users> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Users> fenyeLimit(@Param("offset") int offset, @Param("limit") int limit);

    Users selectByShang(int id);

    List<Users> queryAll(Users users);

    int insert(Users users);

    int update(Users users);

    int deleteById(Integer id);

}