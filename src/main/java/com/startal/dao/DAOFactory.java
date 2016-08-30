package com.startal.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DAOFactory {
    private JdbcTemplate jdbcTemplate;

    private DAOFactory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ProfileDAO getProfileDAO() {
        return new ProfileDAO(jdbcTemplate);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String driverName;
        private String dbUrl;

        public Builder withDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder withDbUrl(String dbUrl) {
            this.dbUrl = dbUrl;
            return this;
        }

        private DataSource createDataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(this.driverName);
            dataSource.setUrl(this.dbUrl);

            return dataSource;
        }

        public DAOFactory build() {
            JdbcTemplate template = new JdbcTemplate(createDataSource());
            return new DAOFactory(template);
        }
    }
}
