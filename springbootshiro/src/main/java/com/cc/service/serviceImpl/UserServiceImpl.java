package com.cc.service.serviceImpl;

import com.cc.dao.UserDOMapper;
import com.cc.model.UserDO;
import com.cc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDOMapper userDOMapper;
    @Override
    public UserDO GetUserName(String userName) {
        return userDOMapper.selectByUserName(userName);
    }

    @Override
    public int Register(String username, String password) {
        UserDO userDO=new UserDO();
        try {

            userDO.setUserTelphone(username);
            userDO.setPassword(password);
            userDOMapper.insertSelective(userDO);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }

    @Override
    public int InsertUser(UserDO userDO) {
        userDO.setUpdateAt(new Date());
        userDO.setCreateAt(new Date());
        int result=userDOMapper.insertSelective(userDO);
        return result;
    }

    @Override
    public int DeleteUser(int id) {
        UserDO userDO=new UserDO();
        userDO.setDeleteAt(new Date());
        userDO.setUserId(id);
        return this.UpdateUser(userDO);
    }

    @Override
    public int UpdateUser(UserDO userDO) {
        userDO.setUpdateAt(new Date());
        int result=userDOMapper.updateByPrimaryKeySelective(userDO);
        return result;
    }

    @Override
    public UserDO GetUser(int id){
        return userDOMapper.selectByPrimaryKey(id);
    }


}

