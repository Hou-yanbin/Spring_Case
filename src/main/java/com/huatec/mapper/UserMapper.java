package com.huatec.mapper;

import com.huatec.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> userList();


    User findUserByUsernamePassword(User user);

    void saveUser(User user);
}
