package com.huatec.dao.impl;

import com.huatec.dao.RoleDao;
import com.huatec.domain.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {

//    使用spring的JdbcTemplet查询数据
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   /* @Test
    public void test1() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplate jdbcTemplate1 = app.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate1);
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        System.out.println(roleList);
    }*/
    @Override
    public List<Role> roleList() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        int i = jdbcTemplate.update("insert into sys_role values(?,?,?)", null, role.getRoleName(), role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long userId) {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role role,sys_user_role ur where role.id=ur.roleId and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), userId);
//        System.out.println(roleList);
        return roleList;
    }
}
