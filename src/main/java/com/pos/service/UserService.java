package com.pos.service;

import com.pos.model.dao.User;
import com.pos.repository.UserDaoImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {



    @Autowired
    private JWTService jwtService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    private UserDaoImpl userDao;


    @Transactional
    public User userRegister(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return user;

    }



    @Transactional
    public User getUserByName(String username) {
        return userDao.findByUsername(username);
    }

    public String verify(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username and password must be provided");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return "Authentication Success";
        } else {
            return "Failed";
        }
    }



}
