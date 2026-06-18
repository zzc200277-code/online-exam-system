package com.example.demo052701.service;

import com.example.demo052701.entity.User;

import java.util.List;

public interface UserService {
    User login(String username, String password);

    boolean register(User user);

    User findById(Integer id);

    User findByMail(String mail);

    List<User> findByStatus(Integer status);

    User findByUsername(String username);

    int updatePassword(String username, String newPassword);
}
