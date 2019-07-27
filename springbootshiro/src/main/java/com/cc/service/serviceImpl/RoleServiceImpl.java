package com.cc.service.serviceImpl;

import com.cc.dao.RoleDOMapper;
import com.cc.dao.RoleMenuDOMapper;
import com.cc.dao.UserRoleDOMapper;
import com.cc.model.RoleDO;
import com.cc.model.RoleMenuDO;
import com.cc.model.UserRoleDO;
import com.cc.response.CommonReturnType;
import com.cc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDOMapper roleDOMapper;
    @Autowired
    private UserRoleDOMapper userRoleDOMapper;
    @Autowired
    private RoleMenuDOMapper roleMenuDOMapper;
    @Override
    public int InsertRole(RoleDO roleDO) {
        roleDO.setUpdateAt(new Date());
        roleDO.setCreateAt(new Date());
        int result=roleDOMapper.insertSelective(roleDO);
        return result;
    }

    @Override
    public int DeleteRole(int id) {
        RoleDO roleDO=new RoleDO();
        roleDO.setDeleteAt(new Date());
        roleDO.setRoleId(id);
        return  this.UpdateRole(roleDO);
    }

    @Override
    public int UpdateRole(RoleDO roleDO) {
        roleDO.setUpdateAt(new Date());
        int result=roleDOMapper.updateByPrimaryKeySelective(roleDO);
        return result;
    }

    @Override
    public RoleDO GetRole(int id) {
        return roleDOMapper.selectByPrimaryKey(id);
    }



    @Override
    public int DeleteUserRole(int id) {
        UserRoleDO userRoleDO=new UserRoleDO();
        userRoleDO.setDeleteAt(new Date());
        return userRoleDOMapper.deleteUserRole(id);
    }

    @Override
    public int DeleteRoleMenu(int id) {
        return roleMenuDOMapper.deleteRoleMenu(id);
    }
}
