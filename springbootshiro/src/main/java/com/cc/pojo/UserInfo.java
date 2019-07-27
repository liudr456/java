package com.cc.pojo;

import com.cc.model.MenuDO;
import com.cc.model.RoleDO;

import java.util.List;

public class UserInfo {
    private String username;
    private String password;
    private String salt="456sd48sa6c4d6g4e86fac4a64g";
    private List<RoleDO> roleList;
    private List<MenuDO> menuList;

    public List<MenuDO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDO> menuList) {
        this.menuList = menuList;
    }

    public List<RoleDO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDO> roleList) {
        this.roleList = roleList;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 密码盐.
     * @return
     */
    public String getSalt(){
       // return this.username+this.salt;
        return this.salt;
    }
    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
