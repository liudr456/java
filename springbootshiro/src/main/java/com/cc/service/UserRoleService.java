package com.cc.service;

import com.cc.model.UserRoleDO;
import com.cc.pojo.UserRoleList;

import java.util.List;
import java.util.Set;

public interface UserRoleService {
    // 用户角色
    int InsertUserRole(UserRoleDO userRoleDO);
    int DeleteUserRole(int id);
    int UpdateUserRole(UserRoleDO userRoleDO);
    UserRoleDO GetUserRole(int id);
    UserRoleDO GetRoleId(int id);
    UserRoleDO GetUserId(int id);
    Set<UserRoleList> GetUserRoleList(int id);
}
