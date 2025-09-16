package com.pos.repository;

import com.pos.model.dao.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
private SessionFactory sessionFactory;

    @Override
    public Role create(Role role) {
        sessionFactory.getCurrentSession().persist(role);
        return role;
    }
}
