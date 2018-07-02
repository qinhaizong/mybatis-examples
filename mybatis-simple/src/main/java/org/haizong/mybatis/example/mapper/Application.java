package org.haizong.mybatis.example.mapper;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.haizong.mybatis.example.CityMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @author qinhaizong
 */
public class Application {

    public static void main(String[] args) {
        DataSource dataSource = new PooledDataSource("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:testdb", "sa", "");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("test", transactionFactory, dataSource);
        Configuration config = new Configuration(environment);
        config.addMapper(CityMapper.class);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(config);
        CityMapper mapper = sessionFactory.openSession().getMapper(CityMapper.class);
        mapper.createCity();
        mapper.initCity();
        List<Map<String, Object>> cities = mapper.findCities();
        cities.stream().forEach(c -> System.out.println(c));
    }
}
