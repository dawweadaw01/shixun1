package com.lhj.shixun1.account.controller;

import com.github.pagehelper.PageInfo;
import com.lhj.shixun1.account.entity.User;
import com.lhj.shixun1.account.service.UserService;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.common.vo.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/account")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 127.0.0.1/api/account/user  --- post
     * @param {"userName":"lhj","password":"111111"}
     * @return
     * MediaType.APPLICATION_JSON_VALUE 这句话的作用是json格式的数据
     */
    @PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }
    /**
     * 127.0.0.1/api/account/user  --- put
     * @param {"id":1,"userName":"lhj","password":"111111"}
     * @return
     */
    @PutMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 127.0.0.1/api/account/user/id  --- delete
     */
    @DeleteMapping(value = "/user/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Object> deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

    /**
     * 127.0.0.1/api/account/user/id
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     *
     * @param {"currentPage":1,"pageSize":5,"sort":"id","direction":"desc","keyword":""}
     * @return
     */
    @PostMapping(value = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<User> getUserBySearch(@RequestBody Search search) {
        return userService.getUserBySearch(search);
    }
    /**
     * 127.0.0.1/api/account/login ---- post
     * {"userName":"cxk", "password":"111111"}
     */
    @PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<User> getUserByParams(@RequestBody User user) {
        return userService.getUserByParams(user);
    }
}
