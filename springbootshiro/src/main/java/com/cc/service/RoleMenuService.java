package com.cc.service;

import com.cc.model.RoleMenuDO;

public interface RoleMenuService {
    // 角色菜单
    int InsertRoleMenu(RoleMenuDO roleMenuDO);
    int DeleteRoleMenu(int id);
    int UpdateRoleMenu(RoleMenuDO roleMenuDO);
    RoleMenuDO GetRoleMenu(int id);
    RoleMenuDO GetRoleId(int id);
    RoleMenuDO GetMenuId(int id);
}
