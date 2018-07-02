package org.haizong.mybatis.example.xml;

import org.haizong.mybatis.example.User;
import org.haizong.mybatis.example.UserMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qinhaizong
 */
public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        UserMapper mapper = context.getBean(UserMapper.class);
        mapper.createTable();
        mapper.insertData();
        User user = mapper.getUser("CA");
        System.out.println(user);
    }
}
