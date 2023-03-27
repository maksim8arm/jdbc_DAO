package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class Repo {
    private final NamedParameterJdbcTemplate template;

    @Autowired
    public Repo(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    private String sqlQuery = read("productName.sql");

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<List<String>> userName(String name) {
        Map<String, String> nameParam = new HashMap<>();
        nameParam.put("name", name);
        List<List<String>> users;
        users = template.query(sqlQuery, nameParam, new Maprow());
        return users;
    }
}
