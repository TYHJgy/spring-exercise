package com.example.spring.exercise.dao;

import com.example.spring.exercise.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
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

     public User selectUserByUserId(String userId) {
         String sql = "SELECT * FROM tbl1 WHERE userId = ?";
         User user = jdbcTemplate.queryForObject(sql,(resultSet, rowNum) -> {
                     User newActor = new User();
             newActor.setAge(resultSet.getString("age"));
             newActor.setUserName(resultSet.getString("userName"));
             newActor.setBirthday(resultSet.getString("birthday"));
             newActor.setUserId(resultSet.getString("userId"));
             System.out.println(resultSet);
             return newActor;
         },userId);
         return user;
    }
    public int insertUser(User user) {
        String sql = "INSERT INTO tbl1 (userName,age,birthday) VALUES (:USERNAME,:AGE,:BIRTHDAY)";
        MapSqlParameterSource msps = new MapSqlParameterSource();
        msps.addValue("USERNAME", user.getUserName());
        msps.addValue("AGE", user.getAge());
        msps.addValue("BIRTHDAY", user.getBirthday());
        return this.namedParameterJdbcTemplate.update(sql, msps);
    }

    public int updateUser(User user) {
        String sql = "UPDATE tbl1 SET userName = :USERNAME , age = :AGE , birthday = :BIRTHDAY WHERE `userId` = :UID";
        MapSqlParameterSource msps = new MapSqlParameterSource();
        msps.addValue("USERNAME", user.getUserName());
        msps.addValue("AGE", user.getAge());
        msps.addValue("BIRTHDAY", user.getBirthday());
        msps.addValue("UID", user.getUserId());
        return this.namedParameterJdbcTemplate.update(sql, msps);
    }

    public int deleteUser(String uid){
        String sql = "DELETE FROM tbl1 WHERE userId = :UID";
        MapSqlParameterSource msps = new MapSqlParameterSource();
        msps.addValue("UID",uid);
        return this.namedParameterJdbcTemplate.update(sql, msps);
    }

}
