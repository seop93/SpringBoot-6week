package com.example.hello.jdbcTemplateExercise.dao;

import javax.sql.DataSource;

public class UserDao {
    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
