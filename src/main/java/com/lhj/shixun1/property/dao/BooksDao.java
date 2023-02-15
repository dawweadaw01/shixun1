package com.lhj.shixun1.property.dao;

import com.lhj.shixun1.account.entity.User;
import com.lhj.shixun1.common.vo.Search;
import com.lhj.shixun1.property.entity.Books;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    @Results(id="booksResults", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "members",
                    javaType = List.class,
                    column = "id",
                    many = @Many(select = "com.lhj.shixun1.property.dao.userDao.getUsersByBooksId")
            ),
    } )
    Books getBooksById(int id);

    @Select("<script>"
            +"select * from economy_books"
            +"<where>"
            +"<if test= 'keyword != \"\" and keyword != null ' >"
            +" and (name like '%${ keyword}%' or books_type like '%${ keyword}%')"
            +"</if>"
            +"</where>"
            +"<choose>"
            +"<when test='sort != \"\" and sort != null '>"
            +" order by ${sort} ${direction}"
            +"</when>"
            +"<otherwise>"
            +" order by id desc"
            +"</otherwise>"
            +"</choose>"
            +"</script>")
    List<Books> getBooksBySearch(Search search);


}
