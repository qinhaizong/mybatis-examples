package org.haizong.mybatis.example;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CityMapper {

    @Select("CREATE TABLE city(id INT PRIMARY KEY, state VARCHAR(100))")
    void createCity();

    @Select("INSERT INTO city (id, state) VALUES (1, 'zh_CN'), (2, 'CA')")
    void initCity();

    @Select("select * from city")
    List<Map<String, Object>> findCities();
}
