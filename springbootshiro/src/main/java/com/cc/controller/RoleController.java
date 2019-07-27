package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.error.BusinessException;
import com.cc.error.EnumBussinessError;
import com.cc.model.RoleDO;
import com.cc.model.RoleMenuDO;
import com.cc.model.UserRoleDO;
import com.cc.response.CommonReturnType;
import com.cc.service.RoleMenuService;
import com.cc.service.RoleService;
import com.cc.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.Map;
/**
 * 角色信息的增删改查
 *
 * */
@Controller("role")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleMenuService roleMenuService;
    @ResponseBody
    @RequestMapping(value="/insert",method = {RequestMethod.POST})
    public CommonReturnType insert(@RequestBody RoleDO roleDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.InsertRole(roleDO);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("保存失败");
        }else {
            commonReturnType=commonReturnType.create("保存成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value="/delete",method = {RequestMethod.POST})
    public CommonReturnType delete(@RequestBody String json) throws BusinessException {
        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ss=(String) jsonObject.get("id");
        int id=Integer.parseInt(ss);
        // 查询是否有相关联用户
        UserRoleDO userRoleDO=userRoleService.GetRoleId(id);
        if(userRoleDO != null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("存在关联用户");
        }
        // 查询是否有相关联权限
        RoleMenuDO roleMenuDO=roleMenuService.GetRoleId(id);
        if(roleMenuDO != null){
            int roleMenuResult=service.DeleteRoleMenu(id);
            if(roleMenuResult == 0){
                throw new BusinessException(EnumBussinessError.UNKNOWN_ERROR);
            }
        }
        // 删除角色
        int result=service.DeleteRole(id);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("删除失败");
        }else {
            commonReturnType=commonReturnType.create("删除成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value="/update",method = {RequestMethod.POST})
    public CommonReturnType update(@RequestBody RoleDO roleDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.UpdateRole(roleDO);
        System.out.println(result);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("更新失败");
        }else {
            commonReturnType=commonReturnType.create("更新成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value="/get",method = {RequestMethod.POST})
    public CommonReturnType get(@RequestBody String json){

        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ss=(String) jsonObject.get("id");
        int id=Integer.parseInt(ss);
        RoleDO roleDO=service.GetRole(id);
        if(roleDO == null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("查找失败");
        }else {
            commonReturnType=commonReturnType.create(roleDO);
        }
        return commonReturnType;
    }
}
