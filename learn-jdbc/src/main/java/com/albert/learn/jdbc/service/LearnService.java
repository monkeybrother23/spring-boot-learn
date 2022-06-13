package com.albert.learn.jdbc.service;

import com.albert.learn.jdbc.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Albert
 * @description
 * @date 2022/6/13
 */
@Service
public class LearnService {
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

    public List<UserModel> test() {
        String sql = "SELECT" +
                " *" +
                " FROM" +
                " develop.sys_user su WHERE user_name = ?";
        return jdbcTemplate.query(sql, new RowMapper<UserModel>() {
            @Override
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel model = new UserModel();
                model.setId(rs.getString("id"));
                model.setName(rs.getString("user_name"));
                model.setAge(rs.getString("age"));
                return model;
            }
        },"albert");
    }

    public List<UserModel> test2() {
        Map<String,String> map = new HashMap<>();
        map.put("id", "2");
        String sql = "SELECT" +
                " *" +
                " FROM" +
                " develop.sys_user su WHERE id = :id";
        return namedParameterJdbcTemplate.query(sql, map, new RowMapper<UserModel>() {
            @Override
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel model = new UserModel();
                model.setId(rs.getString("id"));
                model.setName(rs.getString("user_name"));
                model.setAge(rs.getString("age"));
                return model;
            }
        });
    }
}
