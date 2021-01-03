package com.a.k.podmolot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.a.k.podmolot.entity.Category;

@Component
public class CategoryMapper implements RowMapper<Category>
{

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Category category = new Category();
        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));

        return null;
    }

}
