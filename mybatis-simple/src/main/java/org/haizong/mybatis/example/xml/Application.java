package org.haizong.mybatis.example.xml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.haizong.mybatis.example.City;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author qinhaizong
 */
public class Application {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        session.update("createTable");
        session.commit();
        session.insert("insertData");
        session.commit();
        City city = session.selectOne("select", "CA");
        System.out.println(city);
        session.close();
    }
}
