package com.lhj.shixun1.property.dao;

import com.lhj.shixun1.property.entity.Books;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * BooksDao
 */
@Repository
@Mapper
public interface BooksDao {
    @Insert("insert into economy_books(user_id, name, books_type, default_books, create_time, update_time) " +
            "values(#{userId}, #{name}, #{booksType}, #{defaultBooks}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertBooks(Books books);

    @Select("select * from economy_books where name=#{name} limit 1")
    Books getBooksByName(String name);

    @Update("update economy_books set user_id = #{userId}, name = #{name}, " +
            "books_type = #{booksType}, default_books = #{defaultBooks}, " +
            "update_time = #{updateTime} where id = #{id}")
    void updateBooks(Books books);

    @Delete("delete from economy_books where id = #{id}")
    void deleteBooksById(int id);

    @Select("select * from economy_books where id = #{id}")
    Books getBooksById(int id);
}
