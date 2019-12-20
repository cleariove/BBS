package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.*;
import cn.edu.ncu.bbs.mapper.SubItemMapper;
import cn.edu.ncu.bbs.service.SubItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SubItemServiceImpl implements SubItemService
{
    @Autowired
    private SubItemMapper subItemMapper;

    @Override
    public List<SubItem> selectAll()
    {
        SubItemExample subItemExample = new SubItemExample();
        return subItemMapper.selectByExample(subItemExample);
    }

    @Override
    public List<SubItem> selectByExample(String itemId)
    {
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andItemIdEqualTo(Integer.valueOf(itemId));
        return subItemMapper.selectByExample(subItemExample);
    }

    @Override
    public SubItem selectByPrimaryKey(String subItemId)
    {
        return subItemMapper.selectByPrimaryKey(Integer.valueOf(subItemId));
    }

    @Override
    public void insert(String name, String description, String manager, String itemId)
    {
        SubItem subItem = createSubItem(name, description, manager, itemId);
        subItem.setSubItemIcon("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");
        subItemMapper.insert(subItem);
    }

    @Override
    public void delete(String id)
    {
        subItemMapper.deleteByPrimaryKey(Integer.valueOf(id));
    }

    @Override
    public void setIconPath(String id,String path)
    {
        SubItem subItem = new SubItem();
        subItem.setSubItemIcon(path);
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andSubItemIdEqualTo(Integer.valueOf(id));
        subItemMapper.updateByExampleSelective(subItem,subItemExample);
    }

    @Override
    public void update(String id, String name, String description, String manager, String itemId)
    {
        SubItem subItem = createSubItem(name, description, manager, itemId);
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andSubItemIdEqualTo(Integer.valueOf(id));
        subItemMapper.updateByExampleSelective(subItem,subItemExample);
    }

    private SubItem createSubItem(String name, String description, String manager, String itemId)
    {
        SubItem subItem = new SubItem();
        if(!name.equals(""))
            subItem.setSubItemName(name);
        if(!description.equals(""))
            subItem.setSubItemDescription(description);
        if(!manager.equals(""))
            subItem.setManager(Integer.valueOf(manager));
        if(!itemId.equals(""))
            subItem.setItemId(Integer.valueOf(itemId));
        return subItem;
    }

    @Override
    public int countByItemId(String itemId)
    {
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andItemIdEqualTo(Integer.valueOf(itemId));
        return subItemMapper.countByExample(subItemExample);
    }

    @Override
    public void removePermissionByUserId(Integer id)
    {
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andManagerEqualTo(id);
        SubItem subItem = new SubItem();
        subItem.setManager(3);
        subItemMapper.updateByExampleSelective(subItem,subItemExample);
    }
}
