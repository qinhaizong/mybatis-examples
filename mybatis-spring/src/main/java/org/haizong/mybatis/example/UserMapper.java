package org.haizong.mybatis.example;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author qinhaizong
 */
public interface UserMapper {

    void createTable();

    void insertData();

    @Select("SELECT * FROM users WHERE name = #{name}")
    User getUser(@Param("name") String name);
}
