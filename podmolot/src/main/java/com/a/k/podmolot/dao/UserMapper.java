package com.a.k.podmolot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.a.k.podmolot.entity.User;

@Component
public class UserMapper implements RowMapper<User>
{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setMiddleName(rs.getString("middle_name")); 
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setEmail(rs.getString("mail"));
        return user;
    }

}
