package com.lhj.shixun1.account.service;

import com.github.pagehelper.PageInfo;
import com.lhj.shixun1.account.entity.User;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.common.vo.Search;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result<User> insertUser(User user);

    Result<User> updateUser(User user);

    Result<Object> deleteUser(int id);

    User getUserById(int id);

    PageInfo<User> getUserBySearch(Search search);
}
