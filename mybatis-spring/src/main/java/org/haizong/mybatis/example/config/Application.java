package org.haizong.mybatis.example.config;

import org.haizong.mybatis.example.User;
import org.haizong.mybatis.example.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author qinhaizong
 */
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserMapper mapper = context.getBean(UserMapper.class);
        mapper.createTable();
        mapper.insertData();
        User user = mapper.getUser("CA");
        System.out.println(user);
    }
}
