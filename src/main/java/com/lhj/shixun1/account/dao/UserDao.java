package com.lhj.shixun1.account.dao;
import com.lhj.shixun1.account.entity.User;
import com.lhj.shixun1.common.vo.Search;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Insert("insert into account_user (user_name,password,user_image,create_time,update_time) " +
            "values (#{userName}, #{password},#{userImage},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUser(User user);

    @Select("select * from account_user where user_name = #{userName}")
    User getUserByName(String userName);

    //修改名字，密码和更新时间
    @Update("update account_user set user_name = #{userName}, password = #{password}," +
            "user_image=#{userImage}, update_time = #{updateTime} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from account_user where id = #{id}")
    void deleteUser(int id);

    @Select("select * from account_user where id = #{id}")
    User getUserById(int id);

    @Select("<script>"
            + "select * from account_user "
            +"<where>"
            +"<if test= 'keyword != \"\" and keyword != null ' >"
            + " and (user_name like '%${ keyword}%') "
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
    List<User> getUserBySearch(Search search);

    @Select("select * from account_user au left join economy_books_user ebu " +
            "on au.id = ebu.user_id where ebu.books_id = #{booksId}")
    List<User> getUsersByBooksId(int booksId);

    @Select("select * from account_user where user_name=#{userName} and password=#{password} limit 1")
    User getUserByParams(@Param("userName") String userName, @Param("password") String password);
}
