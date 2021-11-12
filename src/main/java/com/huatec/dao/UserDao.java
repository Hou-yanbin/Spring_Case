package com.huatec.dao;

import com.huatec.domain.User;

import java.util.List;

public interface UserDao {

    List<User> userList();

    Long saveUser(User user);

    void saveUserRoleRel(Long userId, Long[] roleId);

    User findUserByUsernamePassword(String username, String password);
}
