package com.example.dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RepositoryCustomers {
    private final NamedParameterJdbcTemplate template;
    private final String sqlQuery;

    public RepositoryCustomers(NamedParameterJdbcTemplate template) {
        this.template = template;
        this.sqlQuery = read("productName.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> userName(String name) {
        MapSqlParameterSource nameParam = new MapSqlParameterSource("name", name);
        return template.queryForList(sqlQuery, nameParam, String.class);
    }
}
