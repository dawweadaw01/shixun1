package com.lhj.shixun1.property.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhj.shixun1.account.dao.UserDao;
import com.lhj.shixun1.account.entity.User;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.common.vo.Search;
import com.lhj.shixun1.property.dao.BooksDao;
import com.lhj.shixun1.property.entity.Books;
import com.lhj.shixun1.property.dao.BooksUserDao;
import com.lhj.shixun1.property.entity.BooksUser;
import com.lhj.shixun1.property.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksDao booksDao;
    @Autowired
    private BooksUserDao booksUserDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Result<Books> insertBooks(Books books) {
        // 查询账簿名是否存在
        Books temp = booksDao.getBooksByName(books.getName());
        if (temp != null) {
            return Result.failed("账簿名重复。");
        }

        // 初始化账簿对象，并插入books
        books.setCreateTime(LocalDateTime.now());
        books.setUpdateTime(LocalDateTime.now());
        booksDao.insertBooks(books);

        // 循环插入 booksUser 中间表
        books.getMembers().stream().forEach(item -> {
            BooksUser booksUser = new BooksUser(item.getId(), books.getId());
            booksUserDao.insertBooksUser(booksUser);
        });

        // 返回结果
        return Result.ok(books);
    }

    @Override
    @Transactional
    public Result<Books> updateBooks(Books books) {
        // 查询当前账簿名是否和其他重复
        Books temp = booksDao.getBooksByName(books.getName());
        if (temp != null && temp.getId() != books.getId()) {
            return Result.failed("账簿名重复。");
        }
        // 初始化账簿对象
        books.setUpdateTime(LocalDateTime.now());
        // 修改账簿对象
        booksDao.updateBooks(books);
        // 删除BooksUser对应的数据
        booksUserDao.deleteBooksUserByBooksId(books.getId());
        // 建立新的中间表关系
        books.getMembers().stream().forEach(item -> {
            BooksUser booksUser = new BooksUser(item.getId(), books.getId());
            booksUserDao.insertBooksUser(booksUser);
        });
        // 返回结果
        return Result.ok(books);
    }

    @Override
    @Transactional
    public Result<Object> deleteBooksById(int id) {
        // 删除账簿
        booksDao.deleteBooksById(id);
        // 删除中间关系
        booksUserDao.deleteBooksUserByBooksId(id);
        // 返回结果
        return Result.ok();
    }

    @Override
    public Books getBooksById(int id) {
        // 查询 books 对象
//        Books books = booksDao.getBooksById(id);
//        // 查询 members 列表
//        List<User> members = Optional
//                .ofNullable(userDao.getUsersByBooksId(id))
//                .orElse(Collections.emptyList());
//        // 组装返回
//        if (books != null) {
//            books.setMembers(members);
//        }

        // TODO 包装进出、余额数据
        return booksDao.getBooksById(id);
    }

    @Override
    public PageInfo<Books> getBooksBySearch(Search search) {
        search.initSearch();
        PageHelper.startPage(search.getCurrentPage(), search.getPageSize());
        return new  PageInfo<>(Optional
                .ofNullable(booksDao.getBooksBySearch(search))
                .orElse(Collections.emptyList()));
    }
}
