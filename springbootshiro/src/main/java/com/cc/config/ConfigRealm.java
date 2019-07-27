package com.cc.config;

import com.cc.model.*;
import com.cc.pojo.UserInfo;
import com.cc.pojo.UserRoleList;
import com.cc.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
/**
 * 自定义的realm
 * */
public class ConfigRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private MenuService menuService;
    private static Logger logger= LoggerFactory.getLogger(ConfigRealm.class);
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("加入权限doGet~~~");
        logger.info("加入权限");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
      //  UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        String username=(String)principalCollection.getPrimaryPrincipal();
        System.out.println(username);
        int userId=userService.GetUserName(username).getUserId();
        Set<UserRoleList> userRoleList=userRoleService.GetUserRoleList(userId);
        Set<String> permissionSet=new HashSet<>();
        Set<Integer> permissionIdSet=new HashSet<>();
        Set<String> roleSet=new HashSet<>();
        for(UserRoleList list:userRoleList){
            int roleId=list.getUserRoleDO().getRoleId();
            roleSet.add(roleService.GetRole(roleId).getRoleName());
            permissionIdSet.add(roleMenuService.GetRoleId(roleId).getMenuId());
        }
        for(int i: permissionIdSet) {
            permissionSet.add(menuService.GetMenu(i).getMenuName());

        }
//        UserDO userDO = (UserDO) principalCollection.getPrimaryPrincipal();
//        System.out.println(userDO.getUserTelphone()+":"+userDO.getUserName()+":"+userDO.getPassword());
//        authorizationInfo.addRole(roleService.GetRole(1).getRoleName());
//        for(RoleDO roleDO:userInfo.getRoleList()){
//            authorizationInfo.addRole(roleDO.getRoleName());
//            for(MenuDO menuDO:userInfo.getMenuList()){
//                authorizationInfo.addStringPermission(menuDO.getMenuName());
//            }
//        }
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("身份认证");
        logger.debug("身份认证a ");

        String userName = (String) authenticationToken.getPrincipal();
        UserDO userDO = userService.GetUserName(userName);
        String passwordDO = userDO.getPassword();
//        System.out.println(userDO.getUserTelphone());
//        System.out.println(passwordDO);
        if (userDO == null) {
            return null;
        }
     //   Object md = new SimpleHash("MD5", passwordDO);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userDO.getUserTelphone(),
                passwordDO,
                //   ByteSource.Util.bytes(userName),
                getName()
        );
        return simpleAuthenticationInfo;
    }
}
