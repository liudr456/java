package com.cc.pojo;

import com.cc.model.MenuDO;

import java.util.ArrayList;
import java.util.List;

public class MenuList extends MenuDO{
    private MenuDO menuDO;
    private List nodes=new ArrayList();
    public List getNodes() {
        return nodes;
    }

    public MenuDO getMenuDO() {
        return menuDO;
    }

    public void setMenuDO(MenuDO menuDO) {
        this.menuDO = menuDO;
    }


}
