package com.huatec.service.impl;

import com.huatec.dao.RoleDao;
import com.huatec.dao.UserDao;
import com.huatec.domain.Role;
import com.huatec.domain.User;
import com.huatec.mapper.RoleMapper;
import com.huatec.mapper.UserMapper;
import com.huatec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {



    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<User> userList() {
        List<User> userList = userMapper.userList();
//        for (User user:userList) {
//            Long userId = user.getId();
//            List<Role> roleList = roleMapper.findRoleByUserId(userId);
//            user.setRoles(roleList);
//        }
        return userList;
    }

    @Override
    public void saveUser(User user, Long[] roleId) {
       userMapper.saveUser(user);
        Long id = user.getId();
        System.out.println(id);
//        userMapper.saveUserRoleRel(userId,roleId);

    }
    @Override
    public User login(String username, String password) {
        try{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1 = userMapper.findUserByUsernamePassword(user);
            return user1;
        }catch(EmptyResultDataAccessException e){
            return null;
        }

    }
}
