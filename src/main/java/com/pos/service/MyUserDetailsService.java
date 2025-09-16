package com.pos.service;


import com.pos.model.dao.User;
import com.pos.model.dto.UserPrincipal;
import com.pos.repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDaoImpl userDao;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userDao.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }



}
