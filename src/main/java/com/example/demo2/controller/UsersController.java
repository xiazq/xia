package com.example.demo2.controller;

import com.example.demo2.entity.Users;
import com.example.demo2.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2020-07-24 20:50:00
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Users selectOne(Integer id) {
        return usersService.queryById(id);
    }

    /**
     * 增
     */
    @GetMapping("u")
    public boolean update(Users users){
        return this.usersService.update(users);
    }

    /**
     * 改
     */
    @GetMapping("c")
    public boolean create(Users users){ return this.usersService.insert(users); }

    /**
     * 删
     */
    @GetMapping("d")
    public Boolean delete(int id){ return this.usersService.deleteById(id); }

    /**
     *所有
     */
    @GetMapping("l")
    public List<Users> listAll(){ return this.usersService.queryAllByLimit(0,-1); }

    /**
     *分页
     */
    @GetMapping("fy")
    public List<Users> usersList(int pageNum,int pagesize){
        return this.usersService.queryAllByLimit(pageNum*pagesize,pageNum*(pagesize+1));
    }
}