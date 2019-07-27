package com.cc.service;

import com.cc.model.RoleDO;
import com.cc.model.RoleMenuDO;
import com.cc.model.UserRoleDO;

public interface RoleService {
    // 角色
    int InsertRole(RoleDO roleDO);
    int DeleteRole(int id);
    int UpdateRole(RoleDO roleDO);
    RoleDO GetRole(int id);

    int DeleteUserRole(int id);
    int DeleteRoleMenu(int id);
}
