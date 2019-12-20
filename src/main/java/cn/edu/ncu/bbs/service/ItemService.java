package cn.edu.ncu.bbs.service;


import cn.edu.ncu.bbs.domain.Item;

import java.util.List;

public interface ItemService
{
    //插入
    public void insert(String name, String description, String manager);
    //查找全部
    public List<Item> findAll();
    //按主键查找
    public Item selectByPrimaryKey(String itemId);
    //更新
    public int updateByPrimaryKey(String id, String name, String description, String manager);
    //按主键删除
    public int deleteByPrimaryKey(String itemId);
    //设置头像
    public void setIconPath(String id, String base64);
    //移除某人的管理权限
    public void removePermissionByUserId(Integer id);
}
