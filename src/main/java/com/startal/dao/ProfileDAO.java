package com.startal.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by mkalyan on 8/29/16.
 */
public class ProfileDAO {
    private static final Logger logger = LoggerFactory.getLogger(ProfileDAO.class);
    private JdbcTemplate jdbcTemplate;

    public ProfileDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
