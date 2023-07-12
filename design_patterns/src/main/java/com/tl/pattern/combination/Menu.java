package com.tl.pattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单类：属于树枝节点
 */
public class Menu extends MenuComponent{
    //菜单可以有多个子菜单或者子菜单项
    private List<MenuComponent> menuComponentsList = new ArrayList<>();
    //构造方法
    public Menu(String name,int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentsList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentsList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentsList.get(index);
    }

    @Override
    public void print() {
        //打印菜单名称
        for (int i = 0; i < level; i ++){
            System.out.print("--");
        }
        System.out.println(name);

        //打印菜单或者子菜单名称
        for (MenuComponent component : menuComponentsList){
            component.print();
        }
    }
}
