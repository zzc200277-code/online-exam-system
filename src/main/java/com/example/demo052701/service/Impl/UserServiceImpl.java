package com.example.demo052701.service.Impl;

import com.example.demo052701.entity.User;
import com.example.demo052701.mapper.UserMapper;
import com.example.demo052701.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String username, String password) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return null;
        }
        User user = userMapper.findByUsername(username.trim());
        if (user == null || !password.equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    @Override
    public boolean register(User user) {
        if (user == null || !StringUtils.hasText(user.getUsername()) || !StringUtils.hasText(user.getPassword())) {
            return false;
        }
        String username = user.getUsername().trim();
        if (userMapper.findByUsername(username) != null) {
            return false;
        }
        user.setUsername(username);
        if (!StringUtils.hasText(user.getNickname())) {
            user.setNickname(username);
        }
        if (user.getStatus() == null) {
            user.setStatus(1);
        }
        return userMapper.insert(user) == 1;
    }

    @Override
    public User findById(Integer id) {
        return id == null ? null : userMapper.findById(id);
    }

    @Override
    public User findByMail(String mail) {
        return StringUtils.hasText(mail) ? userMapper.findByMail(mail.trim()) : null;
    }

    @Override
    public List<User> findByStatus(Integer status) {
        return userMapper.findByStatus(status);
    }

    @Override
    public User findByUsername(String username) {
        return StringUtils.hasText(username) ? userMapper.findByUsername(username.trim()) : null;
    }

    @Override
    public int updatePassword(String username, String newPassword) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(newPassword)) {
            return 0;
        }
        return userMapper.updatePassword(username.trim(), newPassword);
    }
}
