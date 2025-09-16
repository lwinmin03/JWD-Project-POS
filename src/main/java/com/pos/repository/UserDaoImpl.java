package com.pos.repository;

import com.pos.model.dao.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User save(User user) {
             sessionFactory.getCurrentSession().persist(user);
             return user;
    }

    @Override
    public User findByUsername(String username) {
        return  sessionFactory.getCurrentSession()
                .createQuery("from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();
    }
}
