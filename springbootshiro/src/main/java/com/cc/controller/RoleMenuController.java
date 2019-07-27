package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.model.RoleMenuDO;
import com.cc.response.CommonReturnType;
import com.cc.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 角色权限的增删改查
 * */
@Controller("roleMenu")
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @Autowired
    private RoleMenuService service;


    @ResponseBody
    @RequestMapping(value = "insert",method = {RequestMethod.POST})
    public CommonReturnType insert(@RequestBody RoleMenuDO roleMenuDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.InsertRoleMenu(roleMenuDO);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("保存失败");
        }else {
            commonReturnType=commonReturnType.create("保存成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value = "delete",method = {RequestMethod.POST})
    public CommonReturnType delete(@RequestBody String json){
        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject=JSONObject.parseObject(json);
        String jsonString=(String)jsonObject.get("id");
        int result=service.DeleteRoleMenu(Integer.parseInt(jsonString));
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("删除失败");
        }else {
            commonReturnType=commonReturnType.create("删除成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value = "update",method = {RequestMethod.POST})
    public CommonReturnType update(@RequestBody RoleMenuDO roleMenuDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.UpdateRoleMenu(roleMenuDO);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("更新失败");
        }else {
            commonReturnType=commonReturnType.create("更新成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value = "get",method = {RequestMethod.POST})
    public CommonReturnType get(@RequestBody String json){
        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject=JSONObject.parseObject(json);
        String jsonString=(String)jsonObject.get("id");
//        int id=(Integer)jsonObject.get("id");
        RoleMenuDO roleMenuDO=service.GetRoleMenu(Integer.parseInt(jsonString));
        if(roleMenuDO == null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("查找失败");
        }else {
            commonReturnType=commonReturnType.create(roleMenuDO);
        }
        return commonReturnType;
    }
}
