package com.cc.pojo;

import com.cc.model.UserRoleDO;

import java.util.ArrayList;
import java.util.List;

public class UserRoleList {
    private UserRoleDO userRoleDO;
    private List node=new ArrayList();

    public UserRoleDO getUserRoleDO() {
        return userRoleDO;
    }

    public void setUserRoleDO(UserRoleDO userRoleDO) {
        this.userRoleDO = userRoleDO;
    }

    public List getNode() {
        return node;
    }

    public void setNode(List node) {
        this.node = node;
    }
}
