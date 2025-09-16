package com.pos.controller;


import com.pos.model.dao.Role;
import com.pos.model.dao.User;
import com.pos.service.RoleService;
import com.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private RoleService roleService;


    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.userRegister(user);

    }


    @PostMapping("/role")
    public Role role(@RequestBody Role role) {
        return roleService.createRole(role);

    }
}
