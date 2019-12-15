package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.SubItem;
import cn.edu.ncu.bbs.domain.SubItemExample;
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

    public List<SubItem> selectAll()
    {
        SubItemExample subItemExample = new SubItemExample();
        return subItemMapper.selectByExample(subItemExample);
    }

    public List<SubItem> selectByExample(String itemId)
    {
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andItemIdEqualTo(Integer.valueOf(itemId));
        return subItemMapper.selectByExample(subItemExample);
    }

    public SubItem selectByPrimaryKey(String subItemId)
    {
        return subItemMapper.selectByPrimaryKey(Integer.valueOf(subItemId));
    }

    public void insert(String name, String description, String manager, String itemId)
    {
        SubItem subItem = createSubItem(name, description, manager, itemId);
        subItem.setSubItemIcon("../static/images/subItem.jpg");
        subItemMapper.insert(subItem);
    }

    public void delete(String id)
    {
        subItemMapper.deleteByPrimaryKey(Integer.valueOf(id));
    }

    public void setIconPath(String id,String path)
    {
        SubItem subItem = new SubItem();
        subItem.setSubItemIcon(path);
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andSubItemIdEqualTo(Integer.valueOf(id));
        subItemMapper.updateByExampleSelective(subItem,subItemExample);
    }

    public void update(String id, String name, String description, String manager, String itemId)
    {
        SubItem subItem = createSubItem(name, description, manager, itemId);
        SubItemExample subItemExample = new SubItemExample();
        SubItemExample.Criteria criteria = subItemExample.createCriteria();
        criteria.andItemIdEqualTo(Integer.valueOf(id));
        subItemMapper.updateByExampleSelective(subItem,subItemExample);
    }

    private SubItem createSubItem(String name, String description, String manager, String itemId)
    {
        SubItem subItem = new SubItem();
        subItem.setSubItemName(name);
        subItem.setSubItemDescription(description);
        if(!manager.equals(""))
            subItem.setManager(Integer.valueOf(manager));
        if(!itemId.equals(""))
            subItem.setItemId(Integer.valueOf(itemId));
        return subItem;
    }
}
