package com.cc.service.serviceImpl;

import com.cc.dao.MenuDOMapper;
import com.cc.model.MenuDO;
import com.cc.pojo.MenuList;
import com.cc.response.CommonReturnType;
import com.cc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDOMapper menuDOMapper;
    CommonReturnType commonReturnType=new CommonReturnType();
    @Override
    public int InsertMenu(MenuDO menuDO) {

        menuDO.setCreateAt(new Date());
        menuDO.setUpdateAt(new Date());
        int result= menuDOMapper.insertSelective(menuDO);
        return result;
    }

    @Override
    public int DeleteMenu(int id) {
        MenuDO menuDO=new MenuDO();
        menuDO.setDeleteAt(new Date());
        menuDO.setMenuId(id);
        return this.UpdateMenu(menuDO);
    }

    @Override
    public int UpdateMenu(MenuDO menuDO){
        menuDO.setUpdateAt(new Date());
        int result=menuDOMapper.updateByPrimaryKeySelective(menuDO);
        return result;
    }

    @Override
    public MenuDO GetMenu(int id) {
        return menuDOMapper.selectByPrimaryKey(id);
    }



    @Override
    public List<MenuDO> GetParentid(int id) {
        return menuDOMapper.selectByMenuParentId(id);
    }
}
