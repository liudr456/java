package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.model.UserRoleDO;
import com.cc.response.CommonReturnType;
import com.cc.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *用户角色信息的增删改查
 * */
@Controller("userRole")
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService service;

    @ResponseBody
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public CommonReturnType insert(@RequestBody UserRoleDO userRoleDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.InsertUserRole(userRoleDO);
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
    public CommonReturnType delete(@RequestBody String json){
        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject=JSONObject.parseObject(json);
        String jsonString=(String)jsonObject.get("id");
        int result=service.DeleteUserRole(Integer.parseInt(jsonString));
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
    public CommonReturnType update(@RequestBody UserRoleDO userRoleDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.UpdateUserRole(userRoleDO);
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
        JSONObject jsonObject=JSONObject.parseObject(json);
        String jsonString=(String)jsonObject.get("id");
       UserRoleDO userRoleDO=service.GetUserRole(Integer.parseInt(jsonString));
        if(userRoleDO == null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("查找失败");
        }else {
            commonReturnType=commonReturnType.create(userRoleDO);
        }
        return commonReturnType;
    }
}
