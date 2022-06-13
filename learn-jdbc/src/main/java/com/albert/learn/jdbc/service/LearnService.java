package com.albert.learn.jdbc.service;

import com.albert.learn.jdbc.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Albert
 */
@Service
public class LearnService {
    private static final Logger logger = LoggerFactory.getLogger(LearnService.class);
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<UserModel> queryByArray() {
        String sql = "SELECT id,user_name,age,version_no,create_time,create_by,update_time,update_by" +
                " FROM develop.demo_user du" +
                " WHERE user_name =?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserModel model = new UserModel();
            model.setId(rs.getString("id"));
            model.setName(rs.getString("user_name"));
            model.setAge(rs.getString("age"));
            return model;
        }, "albert");
    }

    public List<UserModel> queryByMap() {
        Map<String, String> map = new HashMap<>();
        map.put("id", "2");
        String sql = "SELECT id,user_name,age,version_no,create_time,create_by,update_time,update_by" +
                " FROM develop.demo_user du" +
                " WHERE id  =:id";
        return namedParameterJdbcTemplate.query(sql, map, (rs, rowNum) -> {
            UserModel model = new UserModel();
            model.setId(rs.getString("id"));
            model.setName(rs.getString("user_name"));
            model.setAge(rs.getString("age"));
            return model;
        });
    }

    public int updateByArray(String id, int age) {
        String sql = "UPDATE" +
                " develop.demo_user" +
                " SET" +
                " age = ?" +
                " WHERE id =?";
        return jdbcTemplate.update(sql, age, id);
    }

    public int updateByMap(String id, int age) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("age", age);
        String sql = "UPDATE" +
                " develop.demo_user" +
                " SET" +
                " age = :age" +
                " WHERE id =:id";
        if (logger.isDebugEnabled()) {
            logger.debug("updateByMap param:{}", map);
        }
        return namedParameterJdbcTemplate.update(sql, map);
    }
}
