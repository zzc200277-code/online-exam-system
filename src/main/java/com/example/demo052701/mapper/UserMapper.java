package com.example.demo052701.mapper;

import com.example.demo052701.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    @Insert("""
            insert into user(username, password, nickname, mail, status, userid, createTime, updateTime)
            values (#{username}, #{password}, #{nickname}, #{mail}, #{status}, #{userid}, now(), now())
            """)
    int insert(User user);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Select("select * from user where mail = #{mail}")
    User findByMail(String mail);

    @Select("select * from user where status = #{status} order by id")
    List<User> findByStatus(Integer status);

    @Update("""
            update user
            set nickname = #{nickname},
                mail = #{mail},
                phone = #{phone},
                avatar = #{avatar},
                updateTime = now()
            where id = #{id}
            """)
    int updateInfo(User user);

    @Update("update user set password = #{newPassword}, updateTime = now() where username = #{username}")
    int updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);
}
