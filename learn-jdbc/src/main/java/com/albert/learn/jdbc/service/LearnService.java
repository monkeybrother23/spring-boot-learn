package com.albert.learn.jdbc.service;

import com.albert.learn.jdbc.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<UserModel> queryByArray(String userName) {
        String sql = "SELECT " +
                " id,user_name,user_age,version_no,create_time,create_by,update_time,update_by" +
                " FROM learn.demo_user du" +
                " WHERE user_name = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            UserModel model = new UserModel();
            model.setId(rs.getString("id"));
            model.setName(rs.getString("user_name"));
            model.setAge(rs.getString("user_age"));
            return model;
        }, userName);
    }

    public List<UserModel> queryByMap(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        String sql = "SELECT" +
                " id,user_name,user_age,version_no,create_time,create_by,update_time,update_by" +
                " FROM learn.demo_user du" +
                " WHERE id  =:id";
        return namedParameterJdbcTemplate.query(sql, map, (rs, rowNum) -> {
            UserModel model = new UserModel();
            model.setId(rs.getString("id"));
            model.setName(rs.getString("user_name"));
            model.setAge(rs.getString("user_age"));
            return model;
        });
    }

    public List<Map<String, Object>> queryForList(String userName) {
        String sql = "SELECT " +
                " id,user_name,user_age,version_no,create_time,create_by,update_time,update_by" +
                " FROM learn.demo_user du" +
                " WHERE user_name = ?";
        return jdbcTemplate.queryForList(sql, userName);
    }

    public List<Map<String, Object>> queryByIN() {
        Map<String, Object> map = new HashMap<>();
        List<String> names = new ArrayList<>();
        names.add("Albert");
        names.add("albert");
        names.add("ben");
        map.put("names", names);
        String sql = "SELECT " +
                " id,user_name,user_age,version_no,create_time,create_by,update_time,update_by" +
                " FROM learn.demo_user du" +
                " WHERE user_name IN (:names)";
        if (logger.isDebugEnabled()) {
            logger.debug("queryByIN param:{}", map);
        }
        return namedParameterJdbcTemplate.queryForList(sql, map);
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

    public int addByArray(UserModel model) {
        String id = UUID.randomUUID().toString().replace("-", "");
        String name = model.getName();
        String age = model.getAge();
        String sql = "INSERT INTO" +
                " learn.demo_user (id, user_name, user_age, version_no, create_time, create_by, update_time, update_by)" +
                " VALUES(?, ?, to_number(?,'999'), 1,now(), 'SYSTEM', now(), 'SYSTEM')";
        if (logger.isDebugEnabled()) {
            logger.debug("addByMap id:{} name:{} age:{}", id, name, age);
        }
        return jdbcTemplate.update(sql, id, name, age);
    }

    public int addByMap(UserModel model) {
        Map<String, Object> map = new HashMap<>();
        String id = UUID.randomUUID().toString().replace("-", "");
        map.put("id", id);
        map.put("name", model.getName());
        map.put("age", model.getAge());
        String sql = "INSERT INTO" +
                " learn.demo_user (id, user_name, user_age, version_no, create_time, create_by, update_time, update_by)" +
                " VALUES(:id, :name, to_number(:age,'999'), 1,now(), 'SYSTEM', now(), 'SYSTEM')";
        if (logger.isDebugEnabled()) {
            logger.debug("addByMap param:{}", map);
        }
        return namedParameterJdbcTemplate.update(sql, map);
    }

    public int deleteByName(String name) {
        String sql = "DELETE FROM learn.demo_user WHERE user_name=?";
        return jdbcTemplate.update(sql, name);
    }

}
