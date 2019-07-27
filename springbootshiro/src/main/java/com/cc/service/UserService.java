package com.cc.service;

import com.cc.model.UserDO;

public interface UserService {
    UserDO GetUserName(String userName);
    // 注册
    int Register(String username,String password);
    // 用户
    int InsertUser(UserDO userDO);
    int DeleteUser(int id);
    int UpdateUser(UserDO userDO);
    UserDO GetUser(int id);



}
