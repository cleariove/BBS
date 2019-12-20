package cn.edu.ncu.bbs.service;

import cn.edu.ncu.bbs.domain.SubItem;

import java.util.List;

public interface SubItemService
{
    //查询所有
    public List<SubItem> selectAll();
    //按所属栏目查
    public List<SubItem> selectByExample(String itemId);
    //按主键查
    public SubItem selectByPrimaryKey(String subItemId);
    //新建子栏目
    public void insert(String name, String description, String manager, String itemId);
    //删除
    public void delete(String id);
    //设置头像
    public void setIconPath(String id,String path);
    //更新
    public void update(String id, String name, String description, String manager, String itemId);
    //某栏目下的滋拉努总数
    public int countByItemId(String itemId);
    //移除某人的权限
    public void removePermissionByUserId(Integer id);
}
