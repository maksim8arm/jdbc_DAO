package com.example.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBconfig {

    @Bean
    public NamedParameterJdbcTemplate template(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
