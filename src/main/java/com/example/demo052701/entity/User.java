package com.example.demo052701.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String mail;
    private String phone;
    private String avatar;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer status;
    private Integer userid;
}
