package com.kanishevskii.services.interfaces;

import com.kanishevskii.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTableUser() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS Users");
        jdbcTemplate.execute("CREATE TABLE Users (Id int ,Email VARCHAR(30),Password VARCHAR)");
    }

    @Override
    public int createUser(User user) {
        String query = "INSERT INTO Users VALUES (" + user.getId() + ",'" + user.getEmail() + "','" + user.getPassword() + "')";
        int result = jdbcTemplate.update(query);
        return result;
    }

    @Override
    public User getUser(long id) {
        String query = "SELECT * FROM Users WHERE Id="+id;
        User result =jdbcTemplate.queryForObject(query,User.class);
        return result;
    }


    @Override
    public int updateUser(User updatedUser, long id) {
        String query = "UPDATE Users SET Email='" + updatedUser.getEmail() + "', password='" + updatedUser.getPassword() + "' WHERE id=" + id;
        int result = jdbcTemplate.update(query);
        return result;
    }

    @Override
    public int deleteUser(long id) {
        String query = "DELETE FROM Users WHERE Id=" + id;
        int result = jdbcTemplate.update(query);
        return result;
    }
}
