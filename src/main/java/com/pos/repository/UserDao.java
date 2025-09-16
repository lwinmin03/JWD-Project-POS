package com.pos.repository;

import com.pos.model.dao.User;

public interface UserDao {
    User save(User user);
    User findByUsername(String username);
}
