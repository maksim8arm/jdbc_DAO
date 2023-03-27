package com.example.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Maprow implements RowMapper<List<String>> {
    @Override
    public List<String > mapRow(ResultSet rs, int rowNum) throws SQLException {
        List<String> listRow = new ArrayList<>();
        listRow.add(rs.getString("product_name"));
        return listRow;
    }
}
