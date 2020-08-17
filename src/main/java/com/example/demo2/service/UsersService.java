package com.example.demo2.service;

import com.example.demo2.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface UsersService {

    Users queryById(Integer id);

    Users selectByShang(int id);

    List<Users> queryAllByLimit(int pageNum,  int pagesize);

    List<Users> fenye(int pageNum, int pagesize);

    boolean insert(Users users);

    boolean update(Users users);

    boolean deleteById(Integer id);

}