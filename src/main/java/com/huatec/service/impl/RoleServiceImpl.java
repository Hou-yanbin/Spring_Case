package com.huatec.service.impl;

import com.huatec.dao.RoleDao;
import com.huatec.domain.Role;
import com.huatec.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> roleList() {
        List<Role> roleList = roleDao.roleList();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
