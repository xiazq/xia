package com.example.demo2.service.impl;

import com.example.demo2.dao.UsersDao;
import com.example.demo2.entity.Users;
import com.example.demo2.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer id) {
        return usersDao.queryById(id);
    }

    @Override
    public Users selectByShang(int id) {
        return usersDao.selectByShang(id);
    }

    /**
     * 查询多条数据
     *
     * @param pageNum  查询页数
     * @param pagesize 每页显示条数
     * @return 对象列表
     */
    @Override
    public List<Users> queryAllByLimit(int pageNum, int pagesize) {
        pageNum=pagesize*pageNum-pagesize;
        return this.usersDao.queryAllByLimit(pageNum, pagesize);

    }

    @Override
    public List<Users> fenye( int pageNum, int pagesize) {
        pageNum=pagesize*pageNum-pagesize;
        return this.usersDao.fenyeLimit(pageNum, pagesize);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(Users users) {
        int insert = usersDao.insert(users);
        return insert > 0;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Users users) {
        int update = usersDao.update(users);
        return update > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return usersDao.deleteById(id) > 0;
    }
}