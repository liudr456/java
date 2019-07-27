package com.cc.service.serviceImpl;

import com.cc.dao.UserRoleDOMapper;
import com.cc.model.UserRoleDO;
import com.cc.pojo.UserRoleList;
import com.cc.response.CommonReturnType;
import com.cc.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDOMapper userRoleDOMapper;
    CommonReturnType commonReturnType=new CommonReturnType();
    @Override
    public int InsertUserRole(UserRoleDO userRoleDO) {
        userRoleDO.setUpadteAt(new Date());
        userRoleDO.setCreateAt(new Date());
        int result=userRoleDOMapper.insertSelective(userRoleDO);
        return  result;
    }

    @Override
    public int DeleteUserRole(int id) {
        UserRoleDO userRoleDO=new UserRoleDO();
        userRoleDO.setDeleteAt(new Date());
        userRoleDO.setUserRoleId(id);
        return this.UpdateUserRole(userRoleDO);
    }

    @Override
    public int UpdateUserRole(UserRoleDO userRoleDO) {
        userRoleDO.setUpadteAt(new Date());
        int result=userRoleDOMapper.updateByPrimaryKeySelective(userRoleDO);
        return result;
    }

    @Override
    public UserRoleDO GetUserRole(int id) {
        return userRoleDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserRoleDO GetRoleId(int id) {
        return userRoleDOMapper.selectByGetRoleId(id);
    }

    @Override
    public UserRoleDO GetUserId(int id) {
        return userRoleDOMapper.selectByGetUserId(id);
    }

    @Override
    public Set<UserRoleList> GetUserRoleList(int id) {
        return userRoleDOMapper.selectUserRoleList(id);
    }
}
