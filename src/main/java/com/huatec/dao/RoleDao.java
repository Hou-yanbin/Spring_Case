package com.huatec.dao;

import com.huatec.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> roleList();

    void save(Role role);

    List<Role> findRoleByUserId(Long userId);
}
