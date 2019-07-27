package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.error.BusinessException;
import com.cc.model.MenuDO;
import com.cc.pojo.MenuList;
import com.cc.response.CommonReturnType;
import com.cc.service.MenuService;
import com.cc.service.RoleMenuService;
import com.cc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("menu")
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService service;
    @Autowired
    private RoleMenuService roleMenuService;
    /**
     * 新增权限
     * @param menuDO 用户信息
     * @return
     * */
    @ResponseBody
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    public CommonReturnType insert(@RequestBody MenuDO menuDO){
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.InsertMenu(menuDO);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("保存失败");
        }else {
            commonReturnType=commonReturnType.create("保存成功");
        }
        return commonReturnType;
    }
    /**
     * 删除权限
     * @param json id
     * @return
     * */
    @ResponseBody
    @RequestMapping(value = "/delete",method = {RequestMethod.POST})
    public CommonReturnType delete(@RequestBody String json){
        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ss=(String) jsonObject.get("id");
        int id=Integer.parseInt(ss);
        if(roleMenuService.GetMenuId(id) != null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("请删除角色权限关系");
        }
        int result=service.DeleteMenu(id);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("删除失败");
        }else {
            commonReturnType=commonReturnType.create("删除成功");
        }
        return commonReturnType;
    }
    /**
     * 修改权限信息
     * @param menuDO 修改信息
     * @return
     * */
    @ResponseBody
    @RequestMapping(value = "/update",method = {RequestMethod.POST})
    public CommonReturnType update(@RequestBody MenuDO menuDO) throws BusinessException {
        CommonReturnType commonReturnType=new CommonReturnType();
        int result=service.UpdateMenu(menuDO);
        if(result == 0){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("更新失败");
        }else {
            commonReturnType=commonReturnType.create("更新成功");
        }
        return commonReturnType;
    }
    /**
     * 查找权限
     * @param json id
     * @return MenuDO
     * */
    @ResponseBody
    @RequestMapping(value = "/get",method = {RequestMethod.POST})
    public CommonReturnType get(@RequestBody String json){
        CommonReturnType commonReturnType=new CommonReturnType();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String ss=(String) jsonObject.get("id");
        int id=Integer.parseInt(ss);
        MenuDO menuDO=service.GetMenu(id);
        if(menuDO == null){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("查找失败");
        }else {
            commonReturnType=commonReturnType.create(menuDO);
        }
        return commonReturnType;
    }
/**
 * 所有菜单信息
* */
    public MenuDO RecursiveNode(int id){
        MenuDO menuDO = service.GetMenu(id);
        List<MenuDO> childTreeNode= service.GetParentid(id);
        for(MenuDO tree:childTreeNode){
            MenuDO child=RecursiveNode(tree.getMenuId());
            menuDO.getNodes().add(child);
        }
        return menuDO;
    }

}
