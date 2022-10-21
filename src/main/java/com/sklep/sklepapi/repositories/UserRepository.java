package com.sklep.sklepapi.repositories;

import com.sklep.sklepapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers() {
        return
            jdbcTemplate.query(
                    "SELECT * FROM user",
                    BeanPropertyRowMapper.newInstance(User.class)
            );

    }


    public User getUserById(int id) {
        return jdbcTemplate.queryForObject(
                        "SELECT * FROM user WHERE id = ?"
                ,BeanPropertyRowMapper.newInstance(User.class),
                id
                );
    }

    public int addUser(List<User> users) {
        int rows =0;
        for (User user : users) {
            rows+= jdbcTemplate.update("INSERT INTO user VALUES(NULL,?,?,?,?,?)",
                    user.getName(),
                    user.getSurname(),
                    user.getEmail(),
                    user.getRole(),
                    user.getPassword());
        }
        return 1;
    }

    public int deleteUser(int id) {
        return jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

    public int putUser(User user) {
        return jdbcTemplate.update("UPDATE user SET name =?, surname=?, email=?,password=?, role=? WHERE id =?",
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getId());
    }

    public int patchUser(User user) {
        return jdbcTemplate.update("UPDATE user SET name =?, surname=?, email=?,password=?, role=? WHERE id =?",
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getId());
    }
}
