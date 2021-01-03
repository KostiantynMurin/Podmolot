package com.a.k.podmolot.dao;

import java.sql.SQLType;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.a.k.podmolot.entity.User;

@Repository
public class UserDaoImpl implements UserDao
{

    private static final String SQL_GET_PROFILE_BY_ID =
            "SELECT * from user WHERE id = :id";
    
    private static final String SQL_GET_PROFILE_BY_EMAIL =
            "SELECT * from user WHERE email = :email";

    private static final String SQL_UPDATE_PROFILE = ""
            + " UPDATE user SET first_name = :firstName ,   \n"
            + "                 last_name = :lastName ,     \n"
            + "                 phone_number = :phoneNumber \n"
            + " WHERE mail = :email                         \n";

    private final UserMapper userMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(UserMapper userMapper, NamedParameterJdbcTemplate jdbcTemplate)
    {
        this.userMapper = userMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> getUserById(long id)
    {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try
        {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_GET_PROFILE_BY_ID, params, userMapper));
        } catch (EmptyResultDataAccessException e)
        {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email)
    {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", email);
        try
        {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_GET_PROFILE_BY_EMAIL, params, userMapper));
        } catch (EmptyResultDataAccessException e)
        {
            return Optional.empty();
        }
    }

    @Override
    public void updateUser(User user, UserDetails currentUser)
    {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("email", currentUser.getUsername());
        params.addValue("firstName", user.getFirstName());
        params.addValue("lastName", user.getLastName());
        params.addValue("phoneNumber", user.getPhoneNumber());
        int a = jdbcTemplate.update(SQL_UPDATE_PROFILE, params);
        System.out.println(a);

    }
}
