package com.lhj.shixun1.property.service;

import com.github.pagehelper.PageInfo;
import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.common.vo.Search;
import com.lhj.shixun1.property.entity.Books;

/**
 * @Description BooksService
 * @Author JiangHu
 * @Date 2023/2/14 15:41
 */
public interface BooksService {

    Result<Books> insertBooks(Books books);

    Result<Books> updateBooks(Books books);

    Result<Object> deleteBooksById(int id);

    Books getBooksById(int id);

    PageInfo<Books> getBooksBySearch(Search search);
}
