package com.cc.service;

import com.cc.error.BusinessException;
import com.cc.model.MenuDO;
import com.cc.pojo.MenuList;

import java.util.List;

public interface MenuService {
    // 菜单
    int InsertMenu(MenuDO menuDO);
    int DeleteMenu(int id);
    int UpdateMenu(MenuDO menuDO) throws BusinessException;
    MenuDO GetMenu(int id);
   List<MenuDO> GetParentid(int id);


}
