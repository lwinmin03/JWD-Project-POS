package com.pos.service;


import com.pos.model.dao.Role;
import com.pos.repository.RoleDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {


    @Autowired
    private RoleDaoImpl roleDao;

   @Transactional
    public Role createRole(Role role) {
        return roleDao.create(role);
    }


}
