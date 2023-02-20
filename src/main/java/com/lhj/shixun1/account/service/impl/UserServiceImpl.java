package com.lhj.shixun1.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhj.shixun1.account.dao.UserDao;
import com.lhj.shixun1.account.entity.User;
import com.lhj.shixun1.account.service.UserService;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.common.vo.Search;
import com.lhj.shixun1.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Override
    @Transactional
    public Result<User> insertUser(User user) {
        User temp = userDao.getUserByName(user.getUserName());
        if(temp != null) {
            return Result.failed("用户名已存在");
        }
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        userDao.insertUser(user);
        return Result.ok(user);
    }

    @Override
    @Transactional
    public Result<User> updateUser(User user) {
        //查询用户名是否存在，相同返回错误信息
        User temp = userDao.getUserByName(user.getUserName());
        if (temp != null && temp.getId() != user.getId()) {
            return Result.failed("用户名已存在");
        }
        //初始化user属性
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        //调用dao层方法
        userDao.updateUser(user);
        //返回正确结果
        return Result.ok(user);
    }

    @Override
    @Transactional
    public Result<Object> deleteUser(int id) {
        //删除user
        userDao.deleteUser(id);
        //返回结果
        return Result.ok();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public PageInfo<User> getUserBySearch(Search search) {
        //设置分页参数
        search.initSearch();
        //开启分页
        PageHelper.startPage(search.getCurrentPage(), search.getPageSize());
        return new PageInfo<>(Optional.ofNullable(userDao.getUserBySearch(search)).orElse(Collections.emptyList()));
    }

    @Override
    public Result<User> getUserByParams(User user) {
        User temp = userDao.getUserByParams(
                user.getUserName(), MD5Util.getMD5(user.getPassword()));
        if (temp != null) {
            return Result.ok(temp);
        }
        return Result.failed("用户名或密码输入错误。");
    }
}
