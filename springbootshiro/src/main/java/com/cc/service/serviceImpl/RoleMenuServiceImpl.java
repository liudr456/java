package com.cc.service.serviceImpl;

import com.cc.dao.RoleMenuDOMapper;
import com.cc.model.RoleMenuDO;
import com.cc.response.CommonReturnType;
import com.cc.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuDOMapper roleMenuDOMapper;
    @Override
    public int InsertRoleMenu(RoleMenuDO roleMenuDO) {
        roleMenuDO.setUpdateAt(new Date());
        roleMenuDO.setCreateAt(new Date());
        int result=roleMenuDOMapper.insertSelective(roleMenuDO);
        return result;
    }

    @Override
    public int DeleteRoleMenu(int id) {
        RoleMenuDO roleMenuDO=new RoleMenuDO();
        roleMenuDO.setDeleteAt(new Date());
        roleMenuDO.setRoleMenuId(id);
        return this.UpdateRoleMenu(roleMenuDO);
    }

    @Override
    public int UpdateRoleMenu(RoleMenuDO roleMenuDO) {
        roleMenuDO.setUpdateAt(new Date());
        int result=roleMenuDOMapper.updateByPrimaryKeySelective(roleMenuDO);
        return result;
    }

    @Override
    public RoleMenuDO GetRoleMenu(int id) {
        return roleMenuDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public RoleMenuDO GetRoleId(int id) {
        return roleMenuDOMapper.selectByGetRoleId(id);
    }

    @Override
    public RoleMenuDO GetMenuId(int id) {
        return roleMenuDOMapper.selectByGetMenuId(id);
    }
}
