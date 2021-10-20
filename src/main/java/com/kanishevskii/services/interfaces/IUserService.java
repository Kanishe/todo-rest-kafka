package com.kanishevskii.services.interfaces;

import com.kanishevskii.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    int createUser (User user);
    User getUser(long id);
    int updateUser(User user);
    int deleteUser (long id);
    void createTableUser();
}
