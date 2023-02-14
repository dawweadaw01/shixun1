package com.lhj.shixun1.property.controller;

import com.lhj.shixun1.common.vo.Result;
import com.lhj.shixun1.property.entity.Books;
import com.lhj.shixun1.property.service.BooksService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;


@RestController
@RequestMapping("/api/economy")
public class BooksController {

    @Autowired
    private BooksService booksService;

    /**
     * 127.0.0.1/api/economy/books ---- post
     * {"userId":1,"name":"时间","booksType":"家庭账簿","defaultBooks":true,"members":[{"id":1}, {"id":2}]}
     */
    @PostMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Books> insertBooks(@RequestBody Books books) {
        return booksService.insertBooks(books);
    }

    /**
     * 127.0.0.1/api/economy/books ---- put
     * {"id":2, "userId":1,"name":"时间1","booksType":"家庭账簿","defaultBooks":true,
     * 	"members":[{"id":3}, {"id":4}]}
     */
    @PutMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Books> updateBooks(@RequestBody Books books) {
        return booksService.updateBooks(books);
    }

    /**
     * 127.0.0.1/api/economy/books/3 ---- delete
     */
    @DeleteMapping(value = "/books/{id}")
    public Result<Object> deleteBooksById(@PathVariable int id) {
        return booksService.deleteBooksById(id);
    }

    /**
     * 127.0.0.1/api/economy/books/2 ---- get
     */
    @GetMapping(value = "/books/{id}")
    public Books getBooksById(@PathVariable int id) {
        return booksService.getBooksById(id);
    }
}
