package org.haizong.mybatis.example.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.haizong.mybatis.example.City;
import org.haizong.mybatis.example.CityMapper;

import javax.sql.DataSource;

/**
 * @author qinhaizong
 */
public class Application {

    public static void main(String[] args) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        DataSource dataSource = new PooledDataSource("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:testdb", "sa", "");
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration config = new Configuration(environment);
        config.addMapper(CityMapper.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = sessionFactory.openSession();
        session.update("createTable");
        session.commit();
        session.insert("insertData");
        session.commit();
        City city = session.selectOne("select", "CA");
        System.out.println(city);
        session.close();
    }
}
