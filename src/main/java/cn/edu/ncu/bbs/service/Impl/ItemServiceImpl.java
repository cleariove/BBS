package cn.edu.ncu.bbs.service.Impl;

import cn.edu.ncu.bbs.domain.Item;
import cn.edu.ncu.bbs.domain.ItemExample;
import cn.edu.ncu.bbs.mapper.ItemMapper;
import cn.edu.ncu.bbs.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService
{
    @Autowired
    private ItemMapper itemMapper;

    public void insert(String name, String description, String manager)
    {
        Item item = new Item();
        item.setItemName(name);
        item.setItemDescription(description);
        item.setItemIcon("../static/images/item.jpg");
        if(!manager.equals(""))
            item.setManager(Integer.valueOf(manager));
        itemMapper.insert(item);
    }

    public List<Item> findAll()
    {
        ItemExample itemExample = new ItemExample();
        return itemMapper.selectByExample(itemExample);
    }

    public Item selectByPrimaryKey(String itemId)
    {
        return itemMapper.selectByPrimaryKey(Integer.valueOf(itemId));
    }

    public int updateByPrimaryKey(String id, String name, String description, String manager)
    {
        Item item = new Item();
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemIdEqualTo(Integer.valueOf(id));
        item.setItemName(name);
        item.setItemDescription(description);
        if(!manager.equals(""))
            item.setManager(Integer.valueOf(manager));
        return itemMapper.updateByExampleSelective(item, itemExample);
    }

    public int deleteByPrimaryKey(String itemId)
    {
        return itemMapper.deleteByPrimaryKey(Integer.valueOf(itemId));
    }

    public void setIconPath(String id, String path)
    {
        Item item = new Item();
        item.setItemIcon(path);
        ItemExample itemExample = new ItemExample();
        ItemExample.Criteria criteria = itemExample.createCriteria();
        criteria.andItemIdEqualTo(Integer.valueOf(id));
        itemMapper.updateByExampleSelective(item, itemExample);
    }
}
