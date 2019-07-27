package com.cc.controller;


import com.alibaba.fastjson.JSONObject;
import com.cc.model.UserDO;
import com.cc.response.CommonReturnType;
import com.cc.service.UserRoleService;
import com.cc.service.UserService;
import com.cc.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息的增删改查
 * */
@Controller("user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    HttpServletResponse httpServletResponse;
    @Autowired
    private UserService service;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private MenuController menuController;


    @ResponseBody
    @RequestMapping(value="/insert",method = {RequestMethod.POST})
    public CommonReturnType insert(@RequestBody UserDO userDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        userDO.setPassword(MD5Utils.encodePassword(userDO.getPassword()));
        System.out.println(userDO.getPassword());
        int result=service.InsertUser(userDO);
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
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ss=(String) jsonObject.get("id");
        int id=Integer.parseInt(ss);
        if(userRoleService.GetUserId(id) != null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("请删除用户角色关系");
        }
        int result=service.DeleteUser(id);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("删除失败");
        }else {
            commonReturnType=commonReturnType.create("删除成功");
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value="/get",method = {RequestMethod.POST})
    public CommonReturnType get(@RequestBody String json){
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ss=(String) jsonObject.get("id");
        int id=Integer.parseInt(ss);
//        int id=(Integer) jsonObject.get("id");
        CommonReturnType commonReturnType=new CommonReturnType();
        UserDO userDO=service.GetUser(id);
        if(userDO == null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("查找失败");
        }else {
            commonReturnType=commonReturnType.create(userDO);
        }
        return commonReturnType;
    }
    @ResponseBody
    @RequestMapping(value="/update",method = {RequestMethod.POST})
    public CommonReturnType update(@RequestBody UserDO userDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.UpdateUser(userDO);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("更新失败");
        }else {
            commonReturnType=commonReturnType.create("更新成功");
        }
        return commonReturnType;
    }




}
